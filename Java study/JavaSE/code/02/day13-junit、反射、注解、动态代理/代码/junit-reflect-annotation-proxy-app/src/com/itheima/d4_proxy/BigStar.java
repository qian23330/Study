package com.itheima.d4_proxy;

public class BigStar implements Star{
    private String name;

    public BigStar(String name) {
        this.name = name;
    }

    public String sing(String name){
        System.out.println(this.name + "正在唱：" + name);
        return "谢谢！谢谢！";
    }

    public void dance(){
        System.out.println(this.name  + "正在优美的跳舞~~");
    }
}
