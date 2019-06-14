package com.bright.com.socket.server.handler;

import com.sun.xml.internal.stream.writers.UTF8OutputStreamWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created By JianBin.Liu on 2019/6/13
 * Description:
 */
public class SocketThread  implements Runnable{

    private Socket socket;

    public SocketThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        //维持心跳
        //处理信息
        BufferedReader input = null;
        PrintStream out = null;
        String str = null;
        System.out.println("客户端请求：");
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintStream(socket.getOutputStream());
            new Thread(new Runnable(){
                @Override
                public void run() {

                }
            }).start();
            while (null != (str = input.readLine())){
                System.out.println(str);
                if("1".equals(str)){
                    out.println("收到数据，值：1");
                }
                else if("2".equals(str)){
                    out.println("收到数据，值：2");
                }
                else if("3".equals(str)){
                    out.println("收到数据，值：3");
                }else {
                    out.println("异常码");
                }

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(null != input) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != out) out.close();
        }
    }
}
