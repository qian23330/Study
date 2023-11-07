package com.itheima.d8_stream;
import java.util.*;
import java.util.stream.Collectors;

/**
   目标：初步体验Stream流的方便与快捷
 */
public class StreamTest1 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "张三丰","张无忌","周芷若","赵敏","张强");
        System.out.println(names);
        // names = [张三丰, 张无忌, 周芷若, 赵敏, 张强]
        //          name

        // 找出姓张，且是3个字的名字，存入到一个新集合中去。
        List<String> list = new ArrayList<>();
        for (String name : names) {
            if(name.startsWith("张") && name.length() == 3){
                list.add(name);
            }
        }
        System.out.println(list);

        // 开始使用Stream流来解决这个需求。
        List<String> list2 = names.stream().filter(s -> s.startsWith("张"))
                .filter(a -> a.length()==3).collect(Collectors.toList());
        System.out.println(list2);
    }
}
