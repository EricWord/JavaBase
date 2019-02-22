package com.xc.c7.day14;

import org.junit.Test;

import java.io.*;

public class TestFileInputStream {
    @Test
    public void testCopyFile2(){
        copyFile2("h1.txt","h3.txt");

    }
    /**
     * 使用FileReader和FileWriter实现文本文件的复制
     * @param src 文件来源
     * @param dest 目标存储地址
     */

    public void copyFile2(String src,String dest){
        File file1 = new File(src);
        File file2 = new File(dest);
        FileReader fr = null;
        FileWriter fw = null;
        char[] c = new char[30];
        int len;
        try {
            fr = new FileReader(file1);
            fw = new FileWriter(file2);
            while ((len=fr.read(c))!=-1){
                fw.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(fr!=null){
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(fw!=null){
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    @Test
    public void testCopyFile() {
        copyFile("h1.txt", "h2.txt");

    }


    @Test
    public void test1() {
        File file = new File("hello.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] b = new byte[5];
            int len;
            while ((len = fis.read(b)) != -1) {
                String s = new String(b, 0, len);
                System.out.print(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 复制文件
     *
     * @param src  文件来源
     * @param dest 目标存放路径
     */
    public void copyFile(String src, String dest) {
        //输入文件
        File file1 = new File(src);
        //输出文件
        File file2 = new File(dest);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        byte[] bytes = new byte[20];
        int len;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ;
        }

        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
