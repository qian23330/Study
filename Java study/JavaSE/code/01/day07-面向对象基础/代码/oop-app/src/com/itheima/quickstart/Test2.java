package com.itheima.quickstart;

public class Test2 {
    public static void main(String[] args) {
        // 目标：掌握类与对象的一些注意事项。
        // 1、类名建议用英文单词，首字母大写，满足驼峰模式，且要有意义，比如：Student、Car…
        // 2、类中定义的变量也称为成员变量（对象的属性），类中定义的方法也称为成员方法（对象的行为）。
        // 3、成员变量本身存在默认值，同学们在定义成员变量时一般来说不需要赋初始值（没有意义）。
        Student s = new Student();
        System.out.println(s.name);
        System.out.println(s.chinese);
        System.out.println(s.math);

        // 4、一个代码文件中，可以写多个class类，但只能一个用public修饰，
        //       且public修饰的类名必须成为代码文件名。
        // 5、对象与对象之间的数据不会相互影响，但多个变量指向同一个对象时就会相互影响了。
        Student s1 = new Student();
        s1.name = "张三";

//        Student s2 = new Student();
//        s2.name = "李四";
        // 把s1变量中存储的学生对象的地址赋值给了s2变量
        Student s2 = s1;
        s2.name = "李四";

        System.out.println(s1.name);

        // 6、如果某个对象没有一个变量引用它，则该对象无法被操作了，该对象会成为所谓的垃圾对象。
        s1 = null;
        s2 = null;
        System.out.println(s1.name);
    }
}
