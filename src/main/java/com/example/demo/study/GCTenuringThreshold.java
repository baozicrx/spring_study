package com.example.demo.study;

public class GCTenuringThreshold {
    public static void main(String[] args) throws Exception {
//        Thread.sleep(5000);
//        System.out.println("start");
//        GCMemoryObject object1 = new GCMemoryObject(2);
//        Thread.sleep(5000);
//        System.out.println("object1");
//        GCMemoryObject object2 = new GCMemoryObject(8);
//        Thread.sleep(5000);
//        System.out.println("object2");
//        GCMemoryObject object3 = new GCMemoryObject(8);
//        Thread.sleep(5000);
//        System.out.println("object3");
//        GCMemoryObject object4 = new GCMemoryObject(8);
//        Thread.sleep(5000);
//        System.out.println("object4");
//        object2 = null;
//        object3 = null;
//        GCMemoryObject object5 = new GCMemoryObject(8);
//        Thread.sleep(4000);
//        object2 = new GCMemoryObject(8);
//        Thread.sleep(5000);
//        System.out.println("object2");
//        object3 = new GCMemoryObject(8);
//        Thread.sleep(5000);
//        System.out.println("object3");
//        object2 = null;
//        object3 = null;
//        object5 = null;
//        GCMemoryObject object6 = new GCMemoryObject(8);
//        Thread.sleep(5000);
        for (int i = 0; i <= 100; i++) {
            GCMemoryObject object = new GCMemoryObject(10);
            System.out.println("object" + i + " start");
            Thread.sleep(5000);
        }
    }
}

class GCMemoryObject {
    private byte[] bytes = null;

    public GCMemoryObject(int multi) {
        bytes = new byte[1024 * 1024 * multi];
    }
}