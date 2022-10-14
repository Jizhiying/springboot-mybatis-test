package com.sunyard.springboot.socket;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        //        Socket socket = new Socket("localhost", 8000);
        //        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //
        //        bufferedWriter.write("world");
        //        bufferedWriter.flush();
        //        String s = bufferedReader.readLine();
        //        System.out.println(s);
        //        socket.close();
        Socket socket = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            socket = new Socket("localhost", 8000);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("test");
            bufferedWriter.write("\n");//使用bufferedwriter时注意写入的内容时字符串的话后面一定要加上/n，要不然接收端一直处于等待状态
            bufferedWriter.flush();
//            bufferedWriter.close();
            String s = bufferedReader.readLine();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
