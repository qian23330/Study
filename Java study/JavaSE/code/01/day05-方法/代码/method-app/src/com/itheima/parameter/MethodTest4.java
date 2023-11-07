package com.itheima.parameter;

public class MethodTest4 {
    public static void main(String[] args) {
        // 目标：完成判断两个int类型的数组是否一样。
        int[] arr1 = {10, 20, 30};
        int[] arr2 = {10, 20, 30};
        System.out.println(equals(arr1, arr2));
    }

    public static boolean equals(int[] arr1, int[] arr2){
        // 1、判断arr1和arr2是否都是null.
        if(arr1 == null && arr2 == null){
            return true; // 相等的
        }

        // 2、判断arr1是null，或者arr2是null.
        if(arr1 == null || arr2 == null) {
            return false; // 不相等
        }

        // 3、判断2个数组的长度是否一样，如果长度不一样，直接返回false.
        if(arr1.length != arr2.length){
            return false; // 不相等
        }

        // 4、两个数组的长度是一样的，接着比较它们的内容是否一样。
        // arr1 = [10, 20, 30]
        // arr2 = [10, 20, 30]
        for (int i = 0; i < arr1.length; i++) {
            // 判断当前位置2个数组的元素是否不一样，不一样直接返回false
            if(arr1[i] != arr2[i]){
                return false; // 不相等的
            }
        }
        return true; // 两个数组是一样的。
    }
}
