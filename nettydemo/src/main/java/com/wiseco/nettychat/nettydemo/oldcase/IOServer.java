package com.wiseco.nettychat.nettydemo.oldcase;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xianqiangliu
 * @date 2019/6/7 10:40
 */
public class IOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        new Thread(()->{
            while(true){
                try{
                    Socket socket = serverSocket.accept();

                    new Thread(()->{
                        try{
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            while ((len=inputStream.read(data))!=-1){
                                System.out.println(new String(data,0,len));
                            }
                        }catch (IOException e){

                        }
                    }).start();
                }catch (IOException e){

                }
                
            }
        }).start();
    }
}
