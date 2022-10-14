package com.sunyard.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    @Pointcut("execution(public * com.sunyard.springboot.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        System.out.println("URL:" + request.getRequestURL().toString());
        System.out.println("METHOD:" + request.getMethod());
        System.out.println("IP:" + request.getRemoteAddr());
        System.out.println("CLASS METHOD:" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS:" + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "log()")
    public void doAfterReturnning(Object ret) {
        System.out.println("Content of returning : " + ret);
    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
    @After("log()")
    public void after(JoinPoint joinPoint) {
        System.out.println("方法最后执行");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("方法环绕start......");
        try {
            Object o = proceedingJoinPoint.proceed();
            System.out.println("方法环绕end......");
            return o;

        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
