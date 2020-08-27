package com.example.demo.study;

class Dervied extends Base {


    private String name = "Java3y";

    private Dervied() {
        tellName();
        printName();
    }

    @Override
    public void tellName() {
        System.out.println("Dervied tell name: " + name);
    }

    @Override
    public void printName() {
        System.out.println("Dervied print name: " + name);
    }

    public static void main(String[] args) {

        new Dervied();
    }
}
