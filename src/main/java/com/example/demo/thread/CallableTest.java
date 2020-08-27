package com.example.demo.thread;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: crx
 * @Create: 9:44 2020/7/1
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> future1 = service.submit(new CallableThread());
        Future<Boolean> future2 = service.submit(new CallableThread());
        Future<Boolean> future3 = service.submit(new CallableThread());
        // 获取返回值
        Boolean b1 = future1.get();
        Boolean b2 = future2.get();
        Boolean b3 = future3.get();

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        // 关闭服务
        service.shutdown();
    }
}
class CallableThread implements Callable{
    @Override
    public Object call() throws Exception {
        return "success";
    }
}
