package com.exam.huawei.round6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 第一题
 * 题意
 * 对于一个文件系统，第一行输入所有的父目录名称，第二行输入所有的子目录/文件名称，第三行输入待查询的文件或目录名称。对于查询的目录或文件名，
 * 如果存在子目录或文件，需要按输入的顺序，按层级输出所有的子目录和文件。“/”表示根目录，没有父目录。
 * 输入描述
 * 第一行是一个由所有的父目录名称组成的字符串，按空格分开。第二行是对应父目录的所有子目录或文件名组成的字符串，按空格分开。第三行是查询的文件名或目录名。
 * 输出描述
 * 按输入的顺序逐层输出所有的子目录和文件，包括查询的目录/文件本身
 * 示例1：
 * 输入：
 * / / / home usr
 * home opt env usr 1.log
 * home
 * 输出：
 * home usr 1.log
 * 查询的home目录包含usr子目录，usr下有一个1.log文件，按顺序输出。
 * 示例2：
 * 输入：
 * / / / home usr
 * home opt env usr 1.log
 * env
 * 输出：
 * env
 * env没有下挂的文件或子目录，直接输出查询本身。
 */
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] parentDirs = sc.nextLine().split(" ");
        String[] subDirs = sc.nextLine().split(" ");
        String find = sc.nextLine();
        int n = parentDirs.length;
        sc.close();
        Queue<String> queue = new LinkedList<>();
        queue.offer(find);
        while(!queue.isEmpty()){
            String str = queue.poll();
            for (int i = 0; i < n; i++) {
                if(parentDirs[i].equals(str)){
                    queue.offer(subDirs[i]);
                }
            }
            System.out.print(str);
            if(!queue.isEmpty()) System.out.print(" ");
        }
    }
}
