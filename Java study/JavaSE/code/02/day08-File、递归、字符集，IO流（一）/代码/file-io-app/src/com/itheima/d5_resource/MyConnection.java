package com.itheima.d5_resource;

public class MyConnection implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("释放了与某个硬件的链接资源~~~~");
    }
}
