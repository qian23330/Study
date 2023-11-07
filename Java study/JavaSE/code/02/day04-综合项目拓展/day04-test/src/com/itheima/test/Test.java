package com.itheima.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        // 目标：完成作业。
        Scanner sc = new Scanner(System.in);
        System.out.println("输入年份和月份(例如：2020-05-01)：");
        String date = sc.next();

        // 转换成LocalDate类。
        LocalDate currentDate = LocalDate.parse(date);
        // 获取当月最后一天日期
        LocalDate lastcurrentDate = currentDate.plusMonths(1).minusDays(1);

        ArrayList<String> dates = new ArrayList<>();
        // 1、计算出2020年2月1日到本月末总共的休息天数，（放到集合中，统计天数）
        LocalDate start = LocalDate.of(2020, 2, 1);
        int count = 0;
        while (true) {
            LocalDate focusDate = start.plusDays(count);
            count++;
            //   1 2 3 4 5 6 7 8 9
            //   0       0       0
            if(count % 4 == 1){
                dates.add("[" + focusDate + "]"); // 加入休息日
            }else {
                dates.add(focusDate.toString());
            }
            // 当前遍历到月末最后一天就结束循环
            if(focusDate.equals(lastcurrentDate)) break;
        }

        System.out.println(dates);
        System.out.println("间隔天数：" + (dates.size() - 1));

        // 从集合dates中遍历最后一个月份的休息日，放到新集合中去。
        ArrayList<String> dates2 = new ArrayList<>();
        int j = dates.size() - 1;
        while (true) {
            String lastDate = dates.get(j);
            if(lastDate.startsWith("[") && lastDate.endsWith("]")){
                dates2.add(lastDate);
            }
            // 拿到当前日期 lastDate
            if(lastDate.contains(date)){
                break;
            }else {
                j--;
            }
        }
        Collections.reverse(dates2); // 反转
        System.out.println(dates2);
        System.out.println("该月休息日天数：" + dates2.size());

        // 从本月的休息日中找到周末。
        // ArrayList<String> dates = new ArrayList<>();
        ArrayList<String> dates3 = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
            String d = dates.get(i);  // 必须是休息日
            if(d.startsWith("[") && d.endsWith("]")) {
                // 这个日期还必须是周末才能加入到集合。
                String d2 = d.replaceAll("\\[", "").replaceAll("]", "");
                LocalDate ld = LocalDate.parse(d2);
                int week = ld.getDayOfWeek().getValue();
                if(week == 6 || week == 7){
                    dates3.add(d2 + "-周" + week);
                }
            }
        }
        System.out.println(dates3);
    }
}
