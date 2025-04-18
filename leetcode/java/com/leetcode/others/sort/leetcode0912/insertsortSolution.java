package com.leetcode.others.sort.leetcode0912;

import java.util.Arrays;
import java.util.Scanner;

class insertsortSolution {
    public int[] sortArray(int[] nums) {
        insertionSort(nums);
        return nums;
    }

    /* 插入排序 */
    private void insertionSort(int[] nums) {
        // 外循环：已排序元素数量为 1, 2, ..., n
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i], j = i - 1;
            // 内循环：将 base 插入到已排序部分的正确位置
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j];  // 将 nums[j] 向右移动一位
                j--;
            }
            nums[j + 1] = base;         // 将 base 赋值到正确位置
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入一组数字，以空格分隔：");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(Arrays.toString(new insertsortSolution().sortArray(nums)));
    }
}
