package com.leetcode.others.practice;

/*
力扣
practice-练习
 */


import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    public int distinctIntegers(int n) {
        set.add(n);
        findNum(n);
        for (Integer i : set) {
            findNum(i);
        }
        return set.size();
    }

    public void findNum(int x) {
        for (int i = 1; i <= x; i++) {
            if (x % i == 1) {
                set.add(i);
            }
        }
    }
}

