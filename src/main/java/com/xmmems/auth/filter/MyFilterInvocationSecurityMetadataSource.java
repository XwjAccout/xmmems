//package com.xmmems.auth.filter;
//
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.util.AntPathMatcher;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
//
//    private final AntPathMatcher antPathMatcher = new AntPathMatcher();
//
//    private final Map<String,String> urlRoleMap = new HashMap<String,String>(){{
//        put("/brand/**","ROLE_BRAND");
//    }};
//
//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
//        FilterInvocation fi = (FilterInvocation) object;
//        String url = fi.getRequestUrl();
//        for(Map.Entry<String,String> entry:urlRoleMap.entrySet()){
//            if(antPathMatcher.match(entry.getKey(), url)){
//                return SecurityConfig.createList(entry.getValue());
//            }
//        }
//        //没有匹配到,默认是要登录才能访问
//        return null;
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return FilterInvocation.class.isAssignableFrom(clazz);
//    }
//}