package com.example.sonaliproject.aop.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Slf4j
public class LoggedAdvice {

    @Around("@annotation(com.example.sonaliproject.aop.annotation.Logged)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().toString();
        String methodName = ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
        Object[] methodArgs = joinPoint.getArgs();
        log.info("ENTER: {}, Method: {}, Arguments: {}", className, methodName, methodArgs);

        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;

        log.info("EXIT: {}, Method: {}, Arguments: {}, Result: {}, TimeTaken: {}ms", className, methodName, methodArgs, result, timeTaken);
        return result;
    }
}
