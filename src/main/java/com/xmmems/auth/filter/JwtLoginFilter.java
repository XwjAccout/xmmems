package com.xmmems.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmmems.auth.config.JwtProperties;
import com.xmmems.common.auth.domain.SysUserToken;
import com.xmmems.common.auth.utils.JwtUtils;
import com.xmmems.common.exception.ExceptionResult;
import com.xmmems.common.exception.XMException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private JwtProperties prop;

    public JwtLoginFilter(AuthenticationManager authenticationManager, JwtProperties prop) {
        this.authenticationManager = authenticationManager;
        this.prop = prop;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response){
        // 跨域支持
        try {
            //页面传的参数
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            //将页面传过来的用户名和密码转成springSecurity的UsernamePasswordAuthenticationToken对象
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
            //调用UserDetailsService中的loadUserByUsername方法，校验用户名和密码是否正确
            return authenticationManager.authenticate(authRequest);
        } catch (Exception e) {
            try {
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = response.getWriter();
                ExceptionResult result = new ExceptionResult(new XMException(501, "用户名或密码不正确！"));
                out.write(new ObjectMapper().writeValueAsString(result));
                out.flush();
                out.close();
            } catch (Exception outEx) {
                outEx.printStackTrace();
            }
            throw new XMException(501, "用户名或密码不正确！");
        }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
           {
        //封装创建token的用户对象
        SysUserToken userToken = new SysUserToken();
        userToken.setUsername(authResult.getName());
        List<String> roles = authResult.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        userToken.setRoles(roles);

        //生成token并写到浏览器的响应头中
        String token = JwtUtils.generateTokenExpireInMinutes(userToken, prop.getPrivateKey(), prop.getUser().getExpire());

        response.setHeader(prop.getUser().getCookieName(), token);
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.addHeader("Access-Control-Max-Age", "1800");
        //30 min
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Expose-Headers", prop.getUser().getCookieName());

        try {
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            Map<String,Object> resultMap = new HashMap<>(4);
            resultMap.put("code", HttpServletResponse.SC_OK);
            resultMap.put("msg", "认证通过！");
            out.write(new ObjectMapper().writeValueAsString(resultMap));
            out.flush();
            out.close();
        } catch (Exception outEx) {
            outEx.printStackTrace();
        }
    }

}
