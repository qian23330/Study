package com.itheima.branch;

public class IfDemo1 {
    public static void main(String[] args) {
        // 目标：需要同学们掌握if分支三种形式的用法和执行流程。
        // 需求：测量用户体温，发现体温高于37度就报警。
        double t = 36.9;
        if(t > 37){
            System.out.println("这个人的温度异常，把他赶紧带走~~");
        }

        // 需求2：发红包，你的钱包余额是99元，现在要发出90元
        // 如果钱够触发发红包的动作，如果钱不够，则提示：余额不足。
        double money = 19;
        if(money >= 90){
            System.out.println("发红包成功了~");
        }else {
            System.out.println("余额不足~~");
        }

        // 需求3：某个公司有一个绩效系统，根据员工的打分输出对应的绩效级别。[0,60) D  [60,80) C [80,90) B [90,100] A
        int score = 298;
        if(score >= 0 && score < 60) {
            System.out.println("您的绩效级别是： D");
        }else if(score >= 60 && score < 80){
            System.out.println("您的绩效级别是： C");
        }else if(score >= 80 && score < 90){
            System.out.println("您的绩效级别是： B");
        }else if(score >= 90 && score <= 100){
            System.out.println("您的绩效级别是： A");
        }else {
            System.out.println("您录入的分数有毛病~~");
        }
    }
}
