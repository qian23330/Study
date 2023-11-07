package com.itheima.demo4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test4 {
    public static void main(String[] args) throws Exception {
        // 目标：红包雨游戏。
        // 1、拿红包进来。
        List<Integer> moneys = getMoneys();
        System.out.println(moneys);
        Collections.shuffle(moneys);
        System.out.println(moneys);

        // 2、创建100个员工
        List<PeopleThread> peopleThreads = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            PeopleThread peopleThread = new PeopleThread(moneys, i + "号");
            peopleThreads.add(peopleThread);
            peopleThread.start();
        }

        // 3、统计谁抢的最多，降序排名。
        for (PeopleThread peopleThread : peopleThreads) {
            peopleThread.join();
        }
        System.out.println("活动结束.......");

        peopleThreads.stream().sorted((p1, p2) -> p2.getTotalMoney() - p1.getTotalMoney())
                .forEach(p -> {
                    System.out.println(p.getName() + "抢红包总计：" + p.getTotalMoney());
                });
    }

    public static List<Integer> getMoneys(){
        // 1、拿红包进来。
        List<Integer> moneys = new ArrayList<>();
        Random r = new Random();
        // 2、按照权重随机红包
        for (int i = 0; i < 160; i++) {
            moneys.add(r.nextInt(30) + 1);
        }

        for (int i = 0; i < 40; i++) {
            moneys.add(r.nextInt(70) + 31);
        }
        return moneys;
    }
}
