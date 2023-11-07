package com.itheima.d1_char_stream;
import java.io.FileWriter;
import java.io.Writer;

/**
 * 目标：搞清楚字符输出流使用时的注意事项。
 */
public class FileWriterTest3 {
    public static void main(String[] args) throws Exception {
        Writer fw = new FileWriter("io-app2/src/itheima03out.txt");

        // 写字符数据出去
        fw.write('a');
        fw.write('b');
        fw.write('c');
        fw.write('d');
        fw.write("\r\n");

        fw.write("我爱你中国");
        fw.write("\r\n");
        fw.write("我爱你中国");

//        fw.flush(); // 刷新流。
//        fw.write("张三");
//        fw.flush();

        fw.close(); // 关闭流，关闭流包含刷新操作！
        // fw.write("张三");
    }
}
