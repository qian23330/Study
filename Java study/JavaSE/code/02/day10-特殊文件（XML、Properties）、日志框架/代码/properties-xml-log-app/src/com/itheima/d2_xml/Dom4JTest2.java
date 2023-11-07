package com.itheima.d2_xml;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * 目标：如何使用程序把数据写出到 XML文件中去。
 * <?xml version="1.0" encoding="UTF-8" ?>
 * <book>
 *     <name>从入门到跑路</name>
 *     <author>dlei</author>
 *     <price>999.9</price>
 * </book>
 */
public class Dom4JTest2 {
    public static void main(String[] args) {
        // 1、使用一个StringBuilder对象来拼接XML格式的数据。
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
        sb.append("<book>\r\n");
        sb.append("\t<name>").append("从入门到跑路").append("</name>\r\n");
        sb.append("\t<author>").append("dlei").append("</author>\r\n");
        sb.append("\t<price>").append(999.99).append("</price>\r\n");
        sb.append("</book>");

        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter("properties-xml-log-app/src/book.xml"));
                ){
            bw.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
