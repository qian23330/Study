package com.itheima.branch;

public class SwitchDemo3 {
    public static void main(String[] args) {
        // 目标：搞清楚switch使用时的几点注意事项。
        // 1、表达式类型只能是byte、short、int、char，JDK5开始支持枚举，JDK7开始支持String、不支持double、float、long。
        int a = 10;
        double b = 0.1;
        double b2 = 0.2;
        double c = b + b2;
        System.out.println(c);
        switch (a){

        }
        // 2、case给出的值不允许重复，且只能是字面量，不能是变量。
        int i = 20;
        int d = 20;
        switch (i){
            case 10:

                break;
            case 20:

                break;
        }
        // 3、正常使用switch的时候，不要忘记写break，否则会出现穿透现象。
        String week = "周三";
        switch (week){
            case "周一":
                System.out.println("埋头苦干，解决bug");
                break;
            case "周二":
                System.out.println("请求大牛程序员帮忙");
                //break;
            case "周三":
                System.out.println("今晚啤酒、龙虾、小烧烤");
                //break;
            case "周四":
                System.out.println("主动帮助新来的女程序解决bug");
                break;
            case "周五":
                System.out.println("今晚吃鸡");
                break;
            case "周六":
                System.out.println("与王婆介绍的小芳相亲");
                break;
            case "周日":
                System.out.println("郁郁寡欢、准备上班");
                break;
            default:
                System.out.println("您输入的星期信息不存在~~~");
        }
    }
}
