package com.xc.ch14.day20;


import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestUDP {

    //发送端
    @Test
    public void send() {
        DatagramSocket ds = null;
        try {

            ds = new DatagramSocket();
            byte[] b = "你好，我是要发送的数据".getBytes();
            DatagramPacket dp = new DatagramPacket(b, 0, b.length, InetAddress.getByName("127.0.0.1"), 9090);
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                ds.close();
            }
        }
    }


    //接收端
    @Test
    public void receive() {
        //这里注意要填写端口号
            DatagramSocket ds=null;
        try {
            ds = new DatagramSocket(9090);
            byte[] b = new byte[1024];
            DatagramPacket dp = new DatagramPacket(b, 0, b.length);
            ds.receive(dp);
            String str = new String(dp.getData(), 0, dp.getLength());
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds!=null){
                ds.close();

            }
        }


    }


}
