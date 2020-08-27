package com.example.demo.study;

/**
 * @Author: crx
 * @Create: 11:33 2020/1/2
 */
public class Singleton {
    //1:volatile修饰
    private static volatile Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        //2:减少不要同步，优化性能
        if (singleton == null) {
            // 3：同步，线程安全
            synchronized (Singleton.class){
                if (singleton == null){
                    //4：创建singleton 对象
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
