package com.itheima.d3_annotation;
@MyTest4(value = "蜘蛛精", aaa=99.5, bbb = {"至尊宝", "黑马"})
@MyTest3
public class Demo {
    @MyTest4(value = "孙悟空", aaa=199.9, bbb = {"紫霞", "牛夫人"})
    public void test1(){
    }
}
