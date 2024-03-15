package com.leetcode.hot100.栈与队列.leetcode0739;

/*
力扣-739-每日温度
hot100-单调栈
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] temperatures = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(temperatures)));
    }
}
