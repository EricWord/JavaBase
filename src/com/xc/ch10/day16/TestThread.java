package com.xc.ch10.day16;

public class TestThread extends Thread {

    public static void main(String[] args) {

        new TestThread().start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);

        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);

        }
    }
}
