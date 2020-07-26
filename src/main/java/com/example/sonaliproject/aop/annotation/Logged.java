package com.example.sonaliproject.aop.annotation;

import java.lang.annotation.*;

/**
 * Logs method entry and exit and the time taken by method execution.
 * Logs class name, method name on entry
 * Logs class name, method name and time taken on exit
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Logged {

}
