package com.codegym.test;

public class Test {
    public static void main(String[] args) {
    long time1 = System.currentTimeMillis();
    for (int i = 0; i < 1000000; i++) {
        System.out.println("Test");
    }
    long time2 = System.currentTimeMillis();

    System.out.println("truoc khi chya for: "+ time1);
    System.out.println("sau khi chay for: "+time2);
    System.out.println("time: "+(time2-time1)+ "mls");
    System.out.println("time: "+(time2-time1)/1000+ "s");

}
}
