package com.xc.ch10.day16;

public class TestRunnerable {
    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();
        Thread t1 = new Thread(printNum);

        Thread t2 = new Thread(printNum);
        t1.start();
        t2.start();


    }


}

class PrintNum implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }


    }
}
