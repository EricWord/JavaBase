package com.xc.ch14.day20;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTCPFile {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            //1.创建socket
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9898);
            //2.创建输出流
            os = socket.getOutputStream();
            //3.创建一个文件输入流
            fis = new FileInputStream(new File("1.jpg"));
            //4.
            int len;
            byte[] b = new byte[1024];
            while ((len = fis.read(b)) != -1) {
                os.write(b, 0, len);
            }
            //显示地告诉服务器已经发送完毕
            socket.shutdownOutput();
            //接收来自服务端的消息
            InputStream is = socket.getInputStream();
            byte[] b2 = new byte[100];
            int len2;
            while ((len2 = is.read(b2)) != -1) {
                String st = new String(b2, 0, len2);
                System.out.println(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
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
            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //服务端
    @Test
    public void server() {

        //不要忘记传入端口号
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            ServerSocket ss = new ServerSocket(9898);
            socket = ss.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream(new File("xiezi.jpg"));
            byte[] b1 = new byte[1024];
            int len1;
            while ((len1 = is.read(b1)) != -1) {
                fos.write(b1, 0, len1);
            }
            System.out.println("收到来自：" + socket.getInetAddress().getHostAddress() + "的文件");
            //给客户端发回消息
            os = socket.getOutputStream();
            os.write("你发来的图片我已收到".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {

                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
        }
    }
}
