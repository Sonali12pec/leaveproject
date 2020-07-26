package com.example.sonaliproject.aop.annotation;

import java.lang.annotation.*;

/**
 * Puts a new entry in MDC with key as 'id' and value random unique string.
 * Used to identify one execution flow in logs
 * Put 'X{id}' in appender pattern for unique id to appear in logs
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestThreadId {
}
