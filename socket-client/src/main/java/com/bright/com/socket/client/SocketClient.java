package com.bright.com.socket.client;

import com.sun.xml.internal.stream.writers.UTF8OutputStreamWriter;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created By JianBin.Liu on 2019/6/13
 * Description:
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        //创建一个Socket对象，访问ServerSocket
        try {
            Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket("127.0.0.1", 9000);
            PrintStream writer = new PrintStream(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                System.out.print("A：");
                String s = scanner.nextLine();
                writer.println(s);
                System.out.println("服务端响应：" + input.readLine());
                if("88".equals(s)){
                    System.out.println("结束连接");
                    writer.close();
                    break;
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
