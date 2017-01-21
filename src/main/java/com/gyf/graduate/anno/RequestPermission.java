package com.gyf.graduate.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by GYF on 2017/1/8.
 */

/**
 * 权限控制注解，在需要权限访问控制的方法上贴上该注解
 */
@Retention(RetentionPolicy.RUNTIME)     //生命周期：运行时
@Target(ElementType.METHOD)     //使用范围：方法
public @interface RequestPermission {
    String value();     //权限名
}
