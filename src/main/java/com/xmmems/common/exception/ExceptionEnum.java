package com.xmmems.common.exception;

import lombok.Getter;

/*
* 成功的操作	状态码
添加	201
查询	200
删除	204
更新	204

*
*
*
* */
@Getter
public enum ExceptionEnum {
    INVALID_FILE_TYPE(400, "无效的文件类型！"),
    INVALID_PARAM_ERROR(400, "无效的请求参数！"),
    INVALID_PHONE_NUMBER(400, "无效的手机号码"),
    INVALID_VERIFY_CODE(400, "验证码错误！"),
    INVALID_USERNAME_PASSWORD(400, "无效的用户名和密码！"),
    INVALID_SERVER_ID_SECRET(400, "无效的服务id和密钥！"),
    INVALID_NOTIFY_PARAM(400, "回调参数有误！"),
    INVALID_NOTIFY_SIGN(400, "回调签名有误！"),

    BASESITE_NOT_FOUND(404, "站点列表不存在！"),
    BASEITEM_NOT_FOUND(404, "监测项目不存在！"),
    SITEITEM_NOT_FOUND(404, "站点监测项目不存在！"),
    BASEAREA_NOT_FOUND(404, "区域信息不存在！"),
    ENVKPITYPE_NOT_FOUND(404, "监测类别不存在！"),
    ENVQUALITYCONF_NOT_FOUND(404, "质量类别不存在！"),
    MONITORREPORT_NOT_FOUND(404, "报表数据不存在！"),
    ROLE_NOT_FOUND(404, "角色列表不存在！"),
    ACCOUNT_NOT_FOUND(404, "账户列表不存在！"),
    MENU_NOT_FOUND(404, "菜单列表不存在！"),
    Permission_NOT_FOUND(404, "权限列表不存在！"),
    ENVWARNRECORD_NOT_FOUND(404, "报警数据不存在！"),
    ENVHOURDATA_NOT_FOUND(404, "报警数据不存在！"),
    DATA_NOT_FOUND(404, "查询数据不存在！"),
    ERROR1(500, "已经是第一个，不可以在上升或下降！"),
    DATA_TRANSFER_ERROR(500, "数据转换异常！"),
    INSERT_OPERATION_FAIL(500, "新增操作失败！"),
    UPDATE_OPERATION_FAIL(500, "更新操作失败！"),
    UPDATE_PASSWORD(500, "修改密码失败！"),
    DELETE_OPERATION_FAIL(500, "删除操作失败！"),
    FILE_UPLOAD_ERROR(500, "文件上传失败！"),
    DIRECTORY_WRITER_ERROR(500, "目录写入失败！"),
    FILE_WRITER_ERROR(500, "文件写入失败！"),
    SEND_MESSAGE_ERROR(500, "短信发送失败！"),
    INVALID_ORDER_STATUS(500, "订单状态不正确！"),
    STOCK_NOT_ENOUGH_ERROR(500, "库存不足！"),
    UNAUTHORIZED(401, "登录失效或未登录！");

    private int status;
    private String message;

    ExceptionEnum(int status, String message) {
        this.status = status;
        this.message = message;
    }
}