package com.itheima.d10_modifer;

import com.itheima.d9_modifer.Fu;

public class Zi extends Fu {
    public void test(){
        // privateMethod(); // 报错
        // method(); // 报错
        protectedMethod();
        publicMethod();
    }
}
