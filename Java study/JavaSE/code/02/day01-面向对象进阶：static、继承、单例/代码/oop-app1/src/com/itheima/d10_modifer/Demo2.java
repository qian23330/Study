package com.itheima.d10_modifer;

import com.itheima.d9_modifer.Fu;

public class Demo2 {
    public static void main(String[] args) {
        Fu f = new Fu();
        // f.privateMethod(); // 报错
        // f.method();
        // f.protecedMethod();
        f.publicMethod();

        Zi zi = new Zi();
        // zi.protectedMethod();
    }
}
