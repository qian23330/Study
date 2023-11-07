package com.itheima.d7_commons_io;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 目标：使用CommonsIO框架进行IO相关的操作。
 */
public class CommonsIOTest1 {
    public static void main(String[] args) throws Exception {
//        FileUtils.copyFile(new File("io-app2\\src\\itheima01.txt"), new File("io-app2/src/a.txt"));
//        FileUtils.copyDirectory(new File("D:\\resource\\私人珍藏"), new File("D:\\resource\\私人珍藏3"));
//        FileUtils.deleteDirectory(new File("D:\\resource\\私人珍藏3"));

        // Java提供的原生的一行代码搞定很多事情
        // Files.copy(Path.of("io-app2\\src\\itheima01.txt"), Path.of("io-app2\\src\\b.txt"));
        System.out.println(Files.readString(Path.of("io-app2\\src\\itheima01.txt")));
    }
}
