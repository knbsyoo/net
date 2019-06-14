package com.bright.com.socket.server.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created By JianBin.Liu on 2019/6/13
 * Description:
 */
@Configuration
public class SocketServerBean {

    @Bean
    public ServerSocket getFirstBean() throws IOException {
        //创建一个ServerSocket 监听192.168.1.10上的8080端口，最大连接数为1。
        //因为服务器可能有1+N（N>=0）个网卡，对应不同的IP
        //如果使用构造函数ServerSocket(port, backlog)，那么默认0.0.0.0，表示适用全部的ip。
        ServerSocket serverSocket = new ServerSocket(9000, 1);
        return serverSocket;
    }
}
