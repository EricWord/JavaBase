package com.xc.ch14.day20;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTCPCom {
    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8989);
            os = socket.getOutputStream();
            os.write("我是客户端".getBytes());
            //显示地告诉服务端发送完毕
            socket.shutdownOutput();
            InputStream is = socket.getInputStream();
            int len;
            byte[] b = new byte[20];
            while ((len = is.read(b)) != -1) {
                String s = new String(b, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    //服务端
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(8989);
            socket = ss.accept();
            is = socket.getInputStream();
            byte[] b = new byte[20];
            int len;
            while ((len = is.read(b)) != -1) {
                String str = new String(b, 0, len);

                System.out.println(str);

                os = socket.getOutputStream();
                os.write("我已收到你的情意".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {

                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ss != null) {

                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
