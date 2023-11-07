package com.itheima.d3_annotation;

/**
 * 自定义注解
 */
public @interface MyTest1 {
    String aaa();
    boolean bbb() default true;
    String[] ccc();
}
