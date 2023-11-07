package com.itheima.d4_collection_set;

import java.util.*;

/**
 * 目标：整体了解一下Set系列集合的特点。
 */
public class SetTest1 {
    public static void main(String[] args) {
        // 1、创建一个Set集合的对象
        //Set<Integer> set = new HashSet<>(); // 创建了一个HashSet的集合对象 一行经典代码  HashSet: 无序 不重复 无索引
        Set<Integer> set = new LinkedHashSet<>(); //  有序 不重复 无索引
//         Set<Integer> set = new TreeSet<>(); //  可排序（升序） 不重复 无索引
        set.add(666);
        set.add(555);
        set.add(555);
        set.add(888);
        set.add(888);
        set.add(777);
        set.add(777);
        System.out.println(set);
    }
}
