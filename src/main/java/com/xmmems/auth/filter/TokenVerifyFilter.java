//package com.xmmems.auth.filter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.xmmems.auth.config.JwtProperties;
//import com.xmmems.common.auth.domain.Payload;
//import com.xmmems.common.auth.domain.SysUserToken;
//import com.xmmems.common.auth.utils.JwtUtils;
//import com.xmmems.common.exception.ExceptionEnum;
//import com.xmmems.common.exception.ExceptionResult;
//import com.xmmems.common.exception.XMException;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class TokenVerifyFilter extends BasicAuthenticationFilter {
//
//    private JwtProperties prop;
//
//    public TokenVerifyFilter(AuthenticationManager authenticationManager, JwtProperties prop) {
//        super(authenticationManager);
//        this.prop = prop;
//    }
//
//    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//        try {
//            String token = request.getHeader(prop.getUser().getCookieName());
//            //String token = CookieUtils.getCookieValue(request, prop.getUser().getCookieName());
//            //验证tken是否正确
//            Payload<SysUserToken> payload = JwtUtils.getInfoFromToken(token, prop.getPublicKey(), SysUserToken.class);
//            SysUserToken user = payload.getUserInfo();
//            List<SimpleGrantedAuthority> list = user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
//            UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken(user.getUsername(), null, list);
//            SecurityContextHolder.getContext().setAuthentication(authResult);
//            chain.doFilter(request, response);
//        } catch (Exception e) {
//            try {
//                response.setContentType("application/json;charset=utf-8");
//                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//                PrintWriter out = response.getWriter();
//                ExceptionResult result = new ExceptionResult(new XMException(ExceptionEnum.UNAUTHORIZED));
//                out.write(new ObjectMapper().writeValueAsString(result));
//                out.flush();
//                out.close();
//            } catch (Exception outEx) {
//                outEx.printStackTrace();
//            }
//            throw new XMException(ExceptionEnum.UNAUTHORIZED);
//        }
//
//    }
//}
//
