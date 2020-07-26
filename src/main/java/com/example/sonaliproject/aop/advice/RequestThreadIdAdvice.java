package com.example.sonaliproject.aop.advice;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Aspect
@Component
@Slf4j
@Order(1)
public class RequestThreadIdAdvice {

    @Around("@annotation(com.example.sonaliproject.aop.annotation.RequestThreadId)")
    public Object logInputOutput(ProceedingJoinPoint proceedingJoinPoint) throws Exception {

        try {
            MDC.put("requestid", UUID.randomUUID().toString());
            log.info("requestId: {}", MDC.get("requestid"));
            Object object = proceedingJoinPoint.proceed();
            log.info("requestId after method execution: {}", MDC.get("requestid"));
            return object;
        } catch (Exception ex) {
            throw ex;
        } catch (Throwable throwable) {
            throw new Exception(throwable);
        } finally {
            MDC.clear();
        }
    }

}
