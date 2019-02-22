package com.xc.c7.day14;

import org.junit.Test;

import java.io.*;

/**
 * 测试使用缓冲流，实现非文本文件的复制
 */
public class TestBuffered {

    @Test
    public void testInputStreamReader() {
        File file1 = new File("h1.txt");
        File file2 = new File("h6.txt");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        BufferedWriter bfw = null;
        BufferedReader bfr = null;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            isr = new InputStreamReader(fis, "UTF-8");
            osw = new OutputStreamWriter(fos, "UTF-8");
            bfr = new BufferedReader(isr);
            bfw = new BufferedWriter(osw);
            String str;
            while ((str = bfr.readLine()) != null) {
                bfw.write(str);
                bfw.newLine();
                bfw.flush();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (bfw != null) {
            try {
                bfw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (bfr != null) {
            try {
                bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testBufferedFileReaderWriter() {
        File file1 = new File("h1.txt");
        File file2 = new File("h5.txt");
        FileReader fr = null;
        FileWriter fw = null;
        BufferedWriter bfw = null;
        BufferedReader bfr = null;
        try {
            fr = new FileReader(file1);
            fw = new FileWriter(file2);

            bfr = new BufferedReader(fr);
            bfw = new BufferedWriter(fw);
            String str;
            while ((str = bfr.readLine()) != null) {
                bfw.write(str);
                bfw.newLine();
                bfw.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (bfw != null) {
            try {
                bfw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (bfr != null) {
            try {
                bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void testBufferedInoutStream() {
        File file1 = new File("h2.txt");
        File file2 = new File("h4.txt");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bfis = null;
        BufferedOutputStream bfos = null;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            bfis = new BufferedInputStream(fis);
            bfos = new BufferedOutputStream(fos);
            byte[] bytes = new byte[5];
            int len;
            while ((len = bfis.read(bytes)) != -1) {
                bfos.write(bytes, 0, len);
                bfos.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bfos != null) {
            try {
                bfos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bfis != null) {
            try {
                bfis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
