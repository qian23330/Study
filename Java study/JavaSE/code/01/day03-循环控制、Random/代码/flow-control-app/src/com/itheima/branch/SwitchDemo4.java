package com.itheima.branch;

public class SwitchDemo4 {
    public static void main(String[] args) {
        // 目标2：理解switch穿透性的作用：
        String week = "周五";
        switch (week){
            case "周一":
                System.out.println("埋头苦干，解决bug");
                break;
            case "周二":
            case "周三":
            case "周四":
                System.out.println("请求大牛程序员帮忙");
                break;
            case "周五":
                System.out.println("自己整理代码");
                break;
            case "周六":
            case "周日":
                System.out.println("打游戏");
                break;
            default:
                System.out.println("您输入的星期信息不存在~~~");
        }

    }
}
