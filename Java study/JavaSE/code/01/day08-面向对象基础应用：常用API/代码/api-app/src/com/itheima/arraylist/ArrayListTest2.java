package com.itheima.arraylist;

import java.util.ArrayList;

/**
    目标：掌握从集合容器中找数据并删除的技巧。

     list.add("Java入门");
     list.add("宁夏枸杞");
     list.add("黑枸杞");
     list.add("人字拖");
     list.add("特级枸杞");
     list.add("枸杞子");
 */
public class ArrayListTest2 {
    public static void main(String[] args) {
        // 1、创建一个ArrayList集合对象
        ArrayList<String> list = new ArrayList<>();
        list.add("枸杞");
        list.add("Java入门");
        list.add("宁夏枸杞");
        list.add("黑枸杞");
        list.add("人字拖");
        list.add("特级枸杞");
        list.add("枸杞子");
        System.out.println(list); // [Java入门, 宁夏枸杞, 黑枸杞, 人字拖, 特级枸杞, 枸杞子]

        // [Java入门, 宁夏枸杞, 黑枸杞, 人字拖, 特级枸杞, 枸杞子]
        // [Java入门, 黑枸杞, 人字拖, 枸杞子]
        //                                 i
        // 2、开始完成需求：从集合中找出包含枸杞的数据并删除它
      /*  for (int i = 0; i < list.size(); i++) {
            // i = 0 1 2 3 4 5
            // 取出当前遍历到的数据
            String ele = list.get(i);
            // 判断这个数据中包含枸杞
            if(ele.contains("枸杞")){
                // 直接从集合中删除该数据
                list.remove(ele);
            }
        }
        System.out.println(list);*/

        // [Java入门,  人字拖]
       //                       i
        // 方式一：每次删除一个数据后，就让i往左边退一步
       /* for (int i = 0; i < list.size(); i++) {
            // i = 0 1 2 3 4 5
            // 取出当前遍历到的数据
            String ele = list.get(i);
            // 判断这个数据中包含枸杞
            if(ele.contains("枸杞")){
                // 直接从集合中删除该数据
                list.remove(ele);
                i--;
            }
        }
        System.out.println(list);*/

        // 方式二：从集合的后面倒着遍历并删除
        // [Java入门, 人字拖]
        //   i
        for (int i = list.size() - 1; i >= 0; i--) {
            // 取出当前遍历到的数据
            String ele = list.get(i);
            // 判断这个数据中包含枸杞
            if(ele.contains("枸杞")){
                // 直接从集合中删除该数据
                list.remove(ele);
            }
        }
        System.out.println(list);
    }
}
