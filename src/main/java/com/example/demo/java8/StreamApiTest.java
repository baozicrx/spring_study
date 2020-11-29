package com.example.demo.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: crx
 * @Create: 17:41 2020/11/29
 */
public class StreamApiTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList() {{
            add("a");
            add("d");
            add("b");
            add("c");
        }};

        list.stream()
                .filter(s -> !"b".equals(s))
                .map(String::toUpperCase)
                .forEach(System.out::print);

        //Java8 Stream 流是不能被复用的，一旦你调用任何终端操作，流就会关闭
//        Stream<String> stringStream = list.stream()
//                .filter(s -> !"b".equals(s))
//                .map(String::toUpperCase)
//                .sorted();
//        stringStream.anyMatch("a"::equals);
//        stringStream.anyMatch("c"::equals);

        //为了克服这个限制，我们必须为我们想要执行的每个终端操作创建一个新的流链，
        // 例如，我们可以通过 Supplier 来包装一下流，通过 get() 方法来构建一个新的 Stream 流
//        Supplier<Stream<String>> stringStream2 = () -> list.stream()
//                .filter(s -> !"b".equals(s))
//                .map(String::toUpperCase)
//                .sorted();
//        stringStream2.get().anyMatch("a"::equals);
//        stringStream2.get().anyMatch("c"::equals);
    }
}
