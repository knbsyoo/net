package com.bright.com.socket.server.listener;

import com.bright.com.socket.server.handler.SocketThread;
import com.sun.xml.internal.stream.writers.UTF8OutputStreamWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created By JianBin.Liu on 2019/6/13
 * Description: Socket监听器，在程序启动的时候，监听端口。
 */
@Configuration
public class SocketListener implements ServletContextListener {

    @Autowired
    ServerSocket serverSocket;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        while (true){
            try {
                Socket socket = serverSocket.accept();
                if(null != socket) new Thread(new SocketThread(socket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
