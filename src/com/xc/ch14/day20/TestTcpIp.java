package com.xc.ch14.day20;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestTcpIp {
    @Test
    public void test() throws UnknownHostException {
        InetAddress name = InetAddress.getByName("www.taobao.com");
        System.out.println(name.getHostName());
        System.out.println(name.getHostAddress());//42.236.35.185

    }
}
