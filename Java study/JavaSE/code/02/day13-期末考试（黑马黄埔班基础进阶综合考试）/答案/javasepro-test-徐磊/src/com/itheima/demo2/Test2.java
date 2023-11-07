package com.itheima.demo2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 张全蛋儿  农家乐,野外拓展
 * 李二狗子  轰趴,野外拓展,健身房
 * 翠花     野外拓展，
 * 小帅     轰趴，健身房
 * 有容     农家乐
 */
public class Test2 {
    public static void main(String[] args) {
        // 1、拿数据到程序中来。用对象封装可以，用Map集合封装也可以。
        Map<String, List<String>> selects = new HashMap<>();
        List<String> data1 = new ArrayList<>();
        Collections.addAll(data1, "农家乐", "野外拓展", "轰趴");
        selects.put("张全蛋儿", data1);

        List<String> data2 = new ArrayList<>();
        Collections.addAll(data2, "轰趴", "野外拓展", "健身房");
        selects.put("李二狗子", data2);

        List<String> data3 = new ArrayList<>();
        Collections.addAll(data3,  "野外拓展", "轰趴");
        selects.put("翠花", data3);

        List<String> data4 = new ArrayList<>();
        Collections.addAll(data4, "健身房");
        selects.put("小帅", data4);

        List<String> data5 = new ArrayList<>();
        Collections.addAll(data5, "农家乐");
        selects.put("有容", data5);

        System.out.println(selects);

        // 2、找出每个去处选择的人数，输出人数最多的地方是哪里。
        Map<String, Integer> infos = new HashMap<>();
        selects.forEach((name, datas) -> {
            for (String data : datas) {
                infos.put(data, infos.containsKey(data) ? infos.get(data) + 1 : 1);
            }
        });
        System.out.println("每个去处的人数是：");
        System.out.println(infos);

        // 3、输出去处最多的地方
        System.out.println("选择人最多的去处是");
        Map.Entry<String, Integer> entry =
                infos.entrySet().stream().max((e1, e2) -> e1.getValue() - e2.getValue()).get();
        List<String> names = infos.entrySet().stream().filter(e -> e.getValue() == entry.getValue()).map(e -> e.getKey()).collect(Collectors.toList());
        System.out.println(names);

        // 4、哪些人没有选择去处最多的地方
        System.out.println("如下一些人不想去人数最多的去处：");
        selects.entrySet().stream().filter(e -> {
            boolean flag = true; // 没有包含
            for (String s : e.getValue()) {
                if(names.contains(s)) {
                    flag = false;
                    break;
                }
            }
            return flag;
        }).forEach(e -> System.out.println(e.getKey()));

    }
}
