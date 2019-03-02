package com.xc.ch14.day20;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class TestURL {
    @Test
    public void test() throws IOException {
        URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551535222546&di=7afed0c8ab5276160777f42284f2b44a&imgtype=0&src=http%3A%2F%2Fpic13.nipic.com%2F20110311%2F2531170_160159024847_2.jpg");
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("bg.jpg"));
        byte[] b = new byte[1024];
        int len;
        while ((len = is.read(b)) != -1) {
            fos.write(b, 0, len);
        }
        fos.close();
        is.close();


    }
}
