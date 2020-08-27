package com.example.demo.study;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

/**
 * @Description: IOUtils工具类笔记
 * @Author: crx
 * @Create: 15:04 2020/8/19
 */
public class IOUtilsTest {
    public static void main(String[] args) {
        try {
            //使用指定的字符编码获取InputStream的内容作为字符串列表，每行一个条目
            FileInputStream fileInputStream = new FileInputStream(new File("C:\\Users\\Thunisoft\\Pictures\\Saved Pictures\\test.txt"));
            List<String> list = IOUtils.readLines(fileInputStream, StandardCharsets.UTF_8);
            System.out.println("使用指定的字符编码获取InputStream的内容作为字符串列表，每行一个条目:" + list);

            //将指定的字符串转换为输入流，并使用指定的字符编码将其编码为字节
            InputStream inputStream1 = IOUtils.toInputStream("test", StandardCharsets.UTF_8);
            String content = IOUtils.toString(inputStream1, StandardCharsets.UTF_8);
            System.out.println("将指定的字符串转换为输入流，并使用指定的字符编码将其编码为字节:" + content);

            //以byte[]的形式获取InputStream的内容
            InputStream inputStream2 = IOUtils.toInputStream("test", StandardCharsets.UTF_8);
            byte[] bytes = IOUtils.toByteArray(inputStream2);
            System.out.println("以byte[]的形式获取InputStream的内容:" + Arrays.toString(bytes));

            //使用指定的字符编码获取InputStream的内容作为字符数组
            InputStream inputStream5 = IOUtils.toInputStream("test", StandardCharsets.UTF_8);
            char[] chars = IOUtils.toCharArray(inputStream5, StandardCharsets.UTF_8);
            System.out.println("使用指定的字符编码获取InputStream的内容作为字符数组:" + Arrays.toString(chars));

            //使用指定的字符编码获取InputStream的内容作为String
            InputStream inputStream6 = IOUtils.toInputStream("test", StandardCharsets.UTF_8);
            String s = IOUtils.toString(inputStream6, StandardCharsets.UTF_8);
            System.out.println("使用指定的字符编码获取InputStream的内容作为String:" + s);

            //将指定的字符串转换为输入流，并使用指定的字符编码将其编码为字节
            InputStream inputStream3 = IOUtils.toInputStream("test", StandardCharsets.UTF_8);
            //从输入流中读取字节
            byte[] buffer = new byte[1024];
            System.out.println("从输入流中读取字节:" + IOUtils.read(inputStream3, buffer));

            //将字节从InputStream复制到OutputStream
            InputStream inputStream4 = IOUtils.toInputStream("\n将字节从InputStream复制到OutputStream", StandardCharsets.UTF_8);
            OutputStream outputStream1 = new FileOutputStream("C:\\Users\\Thunisoft\\Pictures\\Saved Pictures\\test.txt", true);
            int copy = IOUtils.copy(inputStream4, outputStream1);
            System.out.println("将字节从InputStream复制到OutputStream:" + copy);

            //使用指定的字符编码将字符从String写入OutputStream上的字节
            OutputStream outputStream2 = new FileOutputStream("C:\\Users\\Thunisoft\\Pictures\\Saved Pictures\\test.txt", true);
            IOUtils.write("\n使用指定的字符编码将字符从String写入OutputStream上的字节", outputStream2, StandardCharsets.UTF_8);
            System.out.println("使用指定的字符编码将字符从String写入OutputStream上的字节:");

            //从给定的OutputStream创建一个BufferedOutputStream
            OutputStream outputStream3 = new FileOutputStream("C:\\Users\\Thunisoft\\Pictures\\Saved Pictures\\test.txt", true);
            BufferedOutputStream buffer1 = IOUtils.buffer(outputStream3);
            System.out.println("从给定的OutputStream创建一个BufferedOutputStream:");

            //使用指定的字符编码以String的形式获取类路径资源的内容
//            String s1 = IOUtils.resourceToString("C:\\Users\\Thunisoft\\Pictures", StandardCharsets.UTF_8);
//            System.out.println("使用指定的字符编码以String的形式获取类路径资源的内容:" + s1);

            //使用指定的字符编码（或默认编码，如果为null），返回InputStream中各行的Iterator
            FileInputStream fileInputStream2 = new FileInputStream(new File("C:\\Users\\Thunisoft\\Pictures\\Saved Pictures\\test.txt"));
            LineIterator lineIterator = IOUtils.lineIterator(fileInputStream2, StandardCharsets.UTF_8);
            while (lineIterator.hasNext()) {
                System.out.println("返回InputStream中各行的Iterator:" + lineIterator.nextLine());
            }

            //比较两个阅读器的内容以确定它们是否相等
            InputStream inputStream7 = IOUtils.toInputStream("test", StandardCharsets.UTF_8);
            InputStream inputStream8 = IOUtils.toInputStream("test", StandardCharsets.UTF_8);
            System.out.println("比较两个阅读器的内容以确定它们是否相等" + IOUtils.contentEquals(inputStream7, inputStream8));

            //从输入字节流中跳过字节
            InputStream inputStream9 = IOUtils.toInputStream("test", StandardCharsets.UTF_8);
            long skip = IOUtils.skip(inputStream9, 2);
            System.out.println("从输入字节流中跳过字节:" + skip);
            System.out.println("跳过后的输入流:" + IOUtils.toString(inputStream9, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
