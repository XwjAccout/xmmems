package com.xmmems.gateway.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmmems.auth.config.JwtProperties;
import com.xmmems.common.auth.domain.Payload;
import com.xmmems.common.auth.domain.SysUserToken;
import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.auth.utils.JwtUtils;
import com.xmmems.common.exception.ExceptionResult;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.JsonUtils;
import com.xmmems.dto.UserDTO;
import com.xmmems.gateway.config.FilterProperties;
import com.xmmems.service.system.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Slf4j
@EnableConfigurationProperties({FilterProperties.class, JwtProperties.class})
@Component
public class AuthFilter extends HttpFilter {
    @Autowired
    private JwtProperties jwtProp;
    @Autowired
    private FilterProperties filterProp;
    @Autowired
    private AccountService accountService;

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //校验白名单
        String method = request.getMethod();
        String remoteHost = request.getRemoteHost();
        log.info("【过滤器】请求进入过滤器！"+request.getMethod() + "  " + request.getRequestURI()+"  "+remoteHost);
        log.info("【过滤器】请求参数！"+ JsonUtils.toString(request.getParameterMap()));

        if (HttpMethod.OPTIONS.toString().equals(method)) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        } else {
            if (isWhite(request.getRequestURI())) {
                log.info("【过滤器】当前用户是白名单，无需认证，继续微服务访问！");
            } else {
                //获取Cookie中的token
                 String token = request.getHeader(jwtProp.getUser().getCookieName());
                //判断token是否存在
                if (StringUtils.isBlank(token)) {
                    //阻止继续访问
                    throw new XMException(401,"【过滤器】当前用户未认证，权限不足！"+remoteHost);
                }
                //解析token
                Payload<SysUserToken> payload = null;
                try {
                    payload = JwtUtils.getInfoFromToken(token, jwtProp.getPublicKey(), SysUserToken.class);
                } catch (Exception e) {
                    //阻止继续访问
                    throw new XMException(401,"【过滤器】当前用户未认证，权限不足！"+remoteHost);
                }

                //得到载荷中的用户信息
                //得到当前认证的用户信息
                SysUserToken loginUser = payload.getUserInfo();
                //得到token的失效时间
                Date expDate = payload.getExpiration();
                //得到刷新点时间
                DateTime refreshTime = new DateTime(expDate).minusMinutes(jwtProp.getUser().getRefreshTime());
                //UserDTO userInfo = new UserDTO() ;
                //如果刷新时间在当前时间之前，就刷新token
                if (loginUser.getId() == null || refreshTime.isBefore(System.currentTimeMillis())) {
                    UserDTO userDTO = accountService.findAccountByUsername(loginUser.getUsername());
                    loginUser.setId(userDTO.getId());
                    loginUser.setNickName(userDTO.getNickName());
                    //重新生成token并写入到cookie中
                    token = JwtUtils.generateTokenExpireInMinutes(loginUser, jwtProp.getPrivateKey(), jwtProp.getUser().getExpire());

                } else if (loginUser.getId() != null && !refreshTime.isBefore(System.currentTimeMillis())) {

                    int state = accountService.selectState(loginUser.getId());
                    if (state == -1) {
                        String err = "用户" + loginUser.getUsername() + "已经被管理员锁定,请联系管理员解锁";
                        log.error(err);

                        try {
                            response.setContentType("application/json;charset=utf-8");
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            PrintWriter out = response.getWriter();
                            ExceptionResult result =  new ExceptionResult(new XMException(500,err));
                            out.write(new ObjectMapper().writeValueAsString(result));
                            out.flush();
                            out.close();
                        } catch (Exception outEx) {
                            outEx.printStackTrace();
                        }

                        throw new XMException(500, err);
                    }
                }
                response.setHeader(jwtProp.getUser().getCookieName(), token);

                //将用户存入到自定义对象中
                UserHolder.setLoginUser(loginUser);
                log.info("【过滤器】执行完毕，继续服务访问！");
            }
        }
        chain.doFilter(request, response);
    }

    /**
     * 判断当前请求是否是白名单
     */
    private boolean isWhite(String requesturi) {
        //遍历所有白名单地址前缀
        for (String allowPath : filterProp.getAllowPaths()) {
            //判断
            //判断如果当前请求路径，包含了其中一个白名单前缀
            if (requesturi.startsWith(allowPath)) {
                //表示当前路径是白名单
                return true;
            }
            if ("/".equals(requesturi)) {
                return true;
            }
        }
        return false;
    }
}
