package com.itheima.d3_collection_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
    拓展：List系列集合的遍历方式.

    List遍历方式：
        （1）for循环。(独有的，因为List有索引)。
        （2）迭代器。
        （3）foreach。
        （4）JDK 1.8新技术。

 */
public class ListTest2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("糖宝宝");
        list.add("蜘蛛精");
        list.add("至尊宝");

        //（1）for循环
        for (int i = 0; i < list.size(); i++) {
            // i = 0 1 2
            String s = list.get(i);
            System.out.println(s);
        }

        //（2）迭代器。
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //（3）增强for循环（foreach遍历）
        for (String s : list) {
            System.out.println(s);
        }

        //（4）JDK 1.8开始之后的Lambda表达式
        list.forEach(s -> {
            System.out.println(s);
        });
    }
}
