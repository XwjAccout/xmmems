package com.xmmems.common.auth.domain;

import org.springframework.stereotype.Component;

@Component
public class UserHolder {
    private static ThreadLocal<SysUserToken> TL = new ThreadLocal<>();

    /**SysUserToken
     * 设置当前用户
     * @param userDTO
     */
    public static void setLoginUser(SysUserToken userDTO) {
        TL.set(userDTO);
    }

    /**
     * 获取当前用户
     * @return
     */
    public static SysUserToken getLoginUser() {
        return TL.get();
    }

    /**
     * 移除当前用户
     */
    public static void removeLoginUser() {
        TL.remove();
    }

    /**
     * 获取登陆用户的id
     *
     * @author: ithxw
     * @Date: 2020/2/26
     * @return: java.lang.Integer
     */
    public static Integer loginId() {
        //验证用户登录信息，异常已经在verifyUser里面判断了，这里无需再判断
        return getLoginUser().getId();
    }

    /**
     * 获取登陆用户的昵称
     *
     * @author: ithxw
     * @Date: 2020/2/26
     * @return: java.lang.String
     */
    public static String getNickName() {
        return getLoginUser().getNickName();
    }

}
