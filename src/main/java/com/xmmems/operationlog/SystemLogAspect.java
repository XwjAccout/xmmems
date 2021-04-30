package com.xmmems.operationlog;

import com.xmmems.common.auth.domain.UserHolder;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.SystemLog;
import com.xmmems.operationlog.annotation.SystemControllerLog;
import com.xmmems.service.SystemLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 定义日志切入类
 */
@Aspect
@Component
@Order(-5)
public class SystemLogAspect {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private SystemLogService systemLogService;


    ///***
    // * 定义service切入点拦截规则，拦截SystemServiceLog注解的方法
    // */
    //@Pointcut("@annotation(com.xmmems.operationlog.annotation.SystemServiceLog)")
    //public void serviceAspect() {
    //}

    /***
     * 定义controller切入点拦截规则，拦截SystemControllerLog注解的方法
     */
    @Pointcut("@annotation(com.xmmems.operationlog.annotation.SystemControllerLog)")
    public void controllerAspect() {
    }

    /**
     * 初始化系统日志对象
     *
     * @param joinPoint
     * @author: ithxw
     * @Date: 2020/3/4
     * @return: com.xmmems.domain.SystemLog
     */
    private SystemLog initSystemLog(JoinPoint joinPoint) {
        SystemLog systemLog = new SystemLog();
        //获取正在访问的用户id
        systemLog.setUserid(UserHolder.loginId() + "");
        //获取请求的ip
        String ip = request.getRemoteAddr();
        systemLog.setRequestip(ip);
        //获取执行的方法名
        systemLog.setActionmethod(joinPoint.getTarget().getClass().getSimpleName() + ":" + joinPoint.getSignature().getName());

        //获取方法执行前时间
        systemLog.setActiondate(new Date());
        return systemLog;

    }

    /***
     * 拦截控制层的操作日志
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("controllerAspect()")
    public Object controllerLog(ProceedingJoinPoint joinPoint) {
        Object proceed = null;
        SystemLog systemLog = initSystemLog(joinPoint);
        //成功的两步操作
        //设置操作信息
        systemLog.setType("1");
        //获取执行方法的注解内容
        systemLog.setDescription(getControllerMethodDescription(joinPoint) + "成功");

        //获取请求参数
        String returnStr = getParams(joinPoint);
        systemLog.setParams(returnStr);


        //放行拦截
        try {
            proceed = joinPoint.proceed();

        } catch (Throwable throwable) {
            System.out.println(systemLog.toString());
            throw new XMException(500, throwable.getMessage());
        }

        systemLogService.save(systemLog);

        return proceed;
    }

    /**
     * 获取请求参数
     *
     * @param joinPoint
     * @author: ithxw
     * @Date: 2020/3/4
     * @return: java.lang.String
     */
    private String getParams(JoinPoint joinPoint) {
        StringBuilder paramStr = new StringBuilder();
        Object[] params = joinPoint.getArgs();
        for (Object param : params) {
            if (param instanceof String) {
                paramStr.append(param).append("---");
            } else if (param instanceof Integer) {
                paramStr.append(param).append("---");
            }
        }
        return paramStr.toString();
    }

    /**
     * 拦截控制层的异常处理操作日志
     *
     * @param joinPoint
     * @param e
     * @throws Throwable
     */
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
    public void doAfterThrowing2(JoinPoint joinPoint, Throwable e) {
        SystemLog systemLog = initSystemLog(joinPoint);

        //失败的四步操作
        systemLog.setType("2");
        systemLog.setDescription(getControllerMethodDescription(joinPoint) + "失败");
        systemLog.setExceptiondetail(e.getMessage());
        systemLog.setExceptioncode(e.getClass().getSimpleName());

        //获取请求参数
        String returnStr = getParams(joinPoint);
        systemLog.setParams(returnStr);

        systemLogService.save(systemLog);

    }

    /***
     * 获取controller的操作信息
     * @param point
     * @return
     */
    public String getControllerMethodDescription(JoinPoint point) {
        //获取连接点目标类名
        String targetName = point.getTarget().getClass().getName();
        //获取连接点签名的方法名
        String methodName = point.getSignature().getName();
        //获取连接点参数
        Object[] args = point.getArgs();
        //根据连接点类的名字获取指定类
        Class targetClass = null;
        try {
            targetClass = Class.forName(targetName);
        } catch (ClassNotFoundException e) {
            throw new XMException(500, e.getMessage());
        }
        //获取类里面的方法
        Method[] methods = targetClass.getMethods();
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == args.length) {
                    SystemControllerLog annotation = method.getAnnotation(SystemControllerLog.class);
                    sb.append(annotation.descrption());
                    switch (annotation.actionType()) {
                        ////操作的类型，1、添加 2、修改 3、删除 4、查询 5、登陆认证
                        case "1":
                            sb.append("：添加");
                            break;
                        case "2":
                            sb.append("：修改");
                            break;
                        case "3":
                            sb.append("：删除");
                            break;
                        case "4":
                            sb.append("：查询");
                            break;
                        case "5":
                            sb.append("：登录认证");
                            break;
                        case "6":
                            sb.append("：下载excel");
                            break;
                        default:
                            sb.append("：其他未知错误");
                            break;
                    }
                }
            }
        }
        return sb.toString();
    }
}
