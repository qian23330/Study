package com.leetcode.others.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(",");
        Arrays.sort(numbers, (s1, s2) -> {
            String combined1 = s1 + s2;
            String combined2 = s2 + s1;
            return combined2.compareTo(combined1);
        });
        StringBuilder largestNumber = new StringBuilder();
        for (String number : numbers) {
            largestNumber.append(number);
        }
        System.out.println(largestNumber);
    }
}
