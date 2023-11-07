package com.itheima.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test1 {
    // 目标：完成幸存者案例。
    // 1、由于每个囚犯是一个对象，并且我们需要每个囚犯的编号和位置，所以我们把囚犯定义成对象来实现这个案例会更好。
    // 2、创建100个囚犯，依次占位，并为期赋值编号（1-200之间的随机数，不能重复）
    public static List<People> peoples = new ArrayList<>();
    public static void main(String[] args) {
        // 3、循环100次，创建100个囚犯，存入集合
        Random r = new Random();
        for (int i = 1; i <= 100; i++) {
            while (true) {
                int code = r.nextInt(200) + 1;
                // 判断这个编号是否是唯一的。
                if (isCanUse(code)) {
                    People p = new People(code, i);
                    peoples.add(p);
                    break; // 代表当前囚犯添加成功！
                }
            }
        }
        System.out.println("囚犯占位：" + peoples);

        // 4、反复删除奇数位置处的人，直到剩余一个人为止。
        // peoples = [p1, p2, p3 , p4, p5, p6.... ]
        //            0   1   2    3    4   5
        while (peoples.size() > 1) {
            // 干掉奇数位置处的人:那不就是留下偶数位置处的人吗？
            List<People> tempPeoples = new ArrayList<>();
            for (int i = 1; i < peoples.size(); i+=2) {
                People p = peoples.get(i);
                tempPeoples.add(p);
            }
            peoples = tempPeoples;
        }
        People luckPeople = peoples.get(0);
        System.out.println(luckPeople);
        // 一行代码一行诗！
    }

    public static boolean isCanUse(int code){
        for (People people : peoples) {
            if(people.getCode() == code) {
                return false; // 重复了，不能用
            }
        }
        return true; // 此编号，没有重复，可以使用！
    }
}
