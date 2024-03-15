package com.leetcode.others.sort.leetcode0912;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
力扣-912-排序数组
排序-快速排序
*/

class quicksortSolution {
    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    /* 元素交换 */
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /* 哨兵划分 */
    private int partition(int[] nums, int left, int right) {
        // 以 随机数 作为基准数
        int i = left, j = right;
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);

        while (i < j) {
            while (i < j && nums[j] >= nums[left])
                j--;          // 从右向左找首个小于基准数的元素
            while (i < j && nums[i] <= nums[left])
                i++;          // 从左向右找首个大于基准数的元素
            swap(nums, i, j); // 交换这两个元素
        }
        swap(nums, i, left);  // 将基准数交换至两子数组的分界线
        return i;             // 返回基准数的索引
    }

    /* 快速排序 */
    public void quickSort(int[] nums, int left, int right) {
        // 子数组长度为 1 时终止递归
        if (left >= right)
            return;
        // 哨兵划分
        int pivot = partition(nums, left, right);
        // 递归左子数组、右子数组
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    public static void main(String[] args) {
        System.out.println("请输入几个数并用逗号隔开：");
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(",");
        int[] nums = Arrays.stream(arr)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(Arrays.toString(new quicksortSolution().sortArray(nums)));
    }
}
