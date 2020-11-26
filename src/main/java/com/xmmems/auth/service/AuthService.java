package com.xmmems.auth.service;

import com.xmmems.auth.config.JwtProperties;
import com.xmmems.common.auth.domain.Payload;
import com.xmmems.common.auth.domain.SysUserToken;
import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.auth.utils.JwtUtils;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.common.utils.CookieUtils;
import com.xmmems.dto.RoleDTO;
import com.xmmems.dto.UserDTO;
import com.xmmems.service.system.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class AuthService implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtProperties prop;

    @Override
    public UserDetails loadUserByUsername(String username) {
        //得到自定义用户对象
        UserDTO userDTO = accountService.findAccountByUsername(username);

//        List<SimpleGrantedAuthority> list = new ArrayList<>();
//        userDTO.getRoles().forEach(role->{
//            SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
//            list.add(grantedAuthority);
//        });

        //通过自定义的角色集合获取springSecurity的角色对象的集合
        List<RoleDTO> roles = userDTO.getRoles();
        if (CollectionUtils.isEmpty(roles)) {
            //没有角色信息
            return new User(userDTO.getUsername(), userDTO.getPassword(), new ArrayList<SimpleGrantedAuthority>());
        }else {
            List<SimpleGrantedAuthority> list = roles
                    .stream()
                    .map(RoleDTO::getName)
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
            //通过自定义的用户对象获取springSecurity的用户对象
            return new User(userDTO.getUsername(), userDTO.getPassword(), list);
        }
    }

    public SysUserToken verifyUser(HttpServletRequest request, HttpServletResponse response) {
        ////获取cookie中的token
        //String header = prop.getUser().getCookieName();
        //String token = request.getHeader(header);
        //if(StringUtils.isBlank(token)){
        //    log.error("验证用户token失败，用户未登陆");
        //    throw new XMException(ExceptionEnum.UNAUTHORIZED);
        //}
        ////验证token是否合法
        //Payload<SysUserToken> payload = null;
        //try {
        //    payload = JwtUtils.getInfoFromToken(token, prop.getPublicKey(), SysUserToken.class);
        //    log.info("验证用户token有效");
        //}catch (Exception e){
        //    log.error("验证用户token失败，用户未登陆");
        //    throw new XMException(ExceptionEnum.UNAUTHORIZED);
        //}
        ////得到载荷中的用户信息
        //SysUserToken userToken = payload.getUserInfo();
        ////得到token的失效时间
        //Date expDate = payload.getExpiration();
        ////得到刷新点时间
        //DateTime refreshTime = new DateTime(expDate).minusMinutes(prop.getUser().getRefreshTime());
        ////如果刷新时间在当前时间之前，就刷新token
        //if(refreshTime.isBefore(System.currentTimeMillis())){
        //    //重新生成token并写入到cookie中
        //    createTokenToCookie(response, userToken);
        //}//   开始时间    刷新点时间    *    失效时间
        SysUserToken loginUser = UserHolder.getLoginUser();
        return loginUser;
    }

    /**
     * 创建token，并直接写回到浏览器的cookie中
     */
    private void createTokenToCookie(HttpServletResponse response, SysUserToken userToken) {
        //生成token
        String token = JwtUtils.generateTokenExpireInMinutes(userToken, prop.getPrivateKey(), prop.getUser().getExpire());
        //将token写回浏览器的cookie中
        CookieUtils.newCookieBuilder()
                .response(response)
                .name(prop.getUser().getCookieName())
                .value(token)
                .httpOnly(true)
                .domain(prop.getUser().getCookieDomain())
                .build();
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        //获取token
        String cookieName = prop.getUser().getCookieName();
        //String token = CookieUtils.getCookieValue(request, cookieName);
        String token = request.getHeader(cookieName);
        if(StringUtils.isBlank(token)){
            //如果当前请求没有token，就无需再做退出操作
            throw new XMException(ExceptionEnum.UNAUTHORIZED);
        }
        //验证token是否合法
        Payload<Object> payload = null;
        try {
            payload = JwtUtils.getInfoFromToken(token, prop.getPublicKey());
        }catch (Exception e){
            throw new XMException(ExceptionEnum.UNAUTHORIZED);
        }
        //获取token的id
        String tokenId = payload.getId();
        //获取当前token的剩余过期时间,单位是毫秒
        long remainTime = payload.getExpiration().getTime() - System.currentTimeMillis();
        //将当前token加入到黑名单
        if(remainTime>1000){
          //  redisTemplate.opsForValue().set(tokenId, "1", remainTime, TimeUnit.MILLISECONDS);
        }
        //删除token
        CookieUtils.deleteCookie(prop.getUser().getCookieName(),
                prop.getUser().getCookieDomain(),
                response);
    }
}
