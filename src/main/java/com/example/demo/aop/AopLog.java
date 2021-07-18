package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created BY DarkSheep ON 2021/7/15 23:24
 * 一个切面类
 **/
@Aspect //标注为切面
@Component //切面类加入Ioc容器中
public class AopLog {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    //线程局部变量,解决多线程中相同变量的访问冲突问题
    ThreadLocal<Long> startTime=new ThreadLocal<>();
    //定义切点
    @Pointcut("execution(public * com.example.demo..*(..))")
    // *:返回值类型 com.example.demo.. 类路径 *(..) 方法名和参数类型
    public void aopWebLog(){}

    @Before(" aopWebLog()")//上文定义的切入点
    public void doBefore(JoinPoint jp)
    {
        startTime.set(System.currentTimeMillis());//收到请求,记录时间
        //记录请求内容
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        logger.info("URL:"+request.getRequestURI());
        logger.info("HTTP方法:"+request.getMethod());
        logger.info("IP地址:"+request.getRemoteAddr());
        //JoinPoint对象与request对象
        logger.info("类的方法:"+jp.getSignature().getDeclaringTypeName()+"."+jp.getSignature().getName());
        logger.info("参数"+request.getQueryString());

    }
    @AfterReturning(pointcut = "aopWebLog()",returning = "retObject")
    public void doAfterReturning(Object retObject)
    {
        //处理完请求返回应答
        logger.info("应答值:"+ retObject);
        logger.info("费时:"+(System.currentTimeMillis()-startTime.get()));
    }
    @AfterThrowing(pointcut = "aopWebLog()",throwing = "ex")
    public void addAfterThrowingLogger(JoinPoint joinPoint,Exception ex)
    {
        logger.error("执行异常",ex);
    }

}
