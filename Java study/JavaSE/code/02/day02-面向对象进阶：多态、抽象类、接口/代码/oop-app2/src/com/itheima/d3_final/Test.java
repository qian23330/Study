package com.itheima.d3_final;

public class Test {
    /**
     * 常量： public static final修饰的成员变量，建议名称全部大写，多个单词下划线连接
     */
    public static final String SCHOOL_NAME = "黑马";
    private final String name = "猪八戒"; // 这种用法没有意义，知道就行

    public static void main(String[] args) {
        // 目标：认识final的作用。
        // 3、final可以修饰变量总规则：有且仅能赋值一次
        /* 变量：
            一，局部变量
            二，成员变量
                1、静态成员变量
                2、实例成员变量
        */
        final int a;
        a = 12;
        // a = 13; // 第二次赋值，出错了

        final double r = 3.14;
        // r = 0.1; // 第二次赋值，出错了

        final int[] arr = {11, 22, 33};
        // arr = null; // 第二次赋值，出错了
        arr[1] = 222;

        // schoolName = "白马"; // 第二次赋值，出错了
        Test t = new Test();
        // t.name = "孙悟空";// 第二次赋值，出错了
    }

    public static void buy(final double z){
        // z = 0.1;// 第二次赋值，出错了
    }
}

// 1、final修饰类，类不能被继承了
final class A{}
//class B extends A{}

// 2、final修饰方法，方法不能被重写了
class C{
    public final void test(){
    }
}
class D extends C{
//    @Override
//    public void test() {
//
//    }
}
