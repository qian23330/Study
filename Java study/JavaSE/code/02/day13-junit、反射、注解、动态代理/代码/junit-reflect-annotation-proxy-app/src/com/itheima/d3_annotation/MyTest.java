package com.itheima.d3_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 注解只能注解方法。
@Retention(RetentionPolicy.RUNTIME) // 让当前注解可以一直存活着。
public @interface MyTest {
}
