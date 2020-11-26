package com.xmmems.common.constant;

public class XmmemsConstants {
    /**
     * 上传图片的路径
     */
    public static final String UPLOAD_IMG_PATH = "D:\\soft\\nginx-1.15.3\\html\\img";
    /**
     * 图片访问的url
     */
    public static final String UPLOAD_IMG_URL = "http://59.39.56.6:6690/img/";
    //public static final String UPLOAD_IMG_URL = "http://.0.0.1:8087/img/";
    /**
     * 上传文件的路径
     */
    public static final String UPLOAD_FILE_PATH = "D:\\soft\\nginx-1.15.3\\html\\file";
    /**
     * 文件访问的url
     */
    //public static final String UPLOAD_FILE_URL = "http://0.0.1:8087/file/";
    public static final String UPLOAD_FILE_URL = "http://59.39.56.6:6690/file/";

    /**
     * 注册时，短信验证码在redis中的key的前缀
     */
    public static final String CODE_PRE = "CODE:PRE:";
    /**
     * 用户id请求头的key  USER:ID:KEY
     */
    public static final String USER_ID_KEY = "USER_ID_KEY";
    /**
     * 用户角色请求头的key
     */
    public static final String USER_ROLE_KEY = "USER_ROLE_KEY";
}
