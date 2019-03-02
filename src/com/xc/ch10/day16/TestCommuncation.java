package com.xc.ch10.day16;

/**
 * 测试线程之间的通信
 */
public class TestCommuncation {
    public static void main(String[] args) {
        PrintN p = new PrintN();
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        t1.setName("甲");
        t2.setName("乙");
        t1.start();
        t2.start();
    }
}

class PrintN implements Runnable {
    int n = 1;


    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                notify();
                if (n <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + n++);
                }else{
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
