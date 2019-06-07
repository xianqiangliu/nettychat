package com.wiseco.nettychat.nettydemo.oldcase;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author xianqiangliu
 * @date 2019/6/7 10:40
 */
public class IOClient {
    public static void main(String[] args) {
        new Thread(()->{
            try{
                Socket socket = new Socket("127.0.0.1",8888);
                while (true){
                    try{
                        socket.getOutputStream().write((new Date()+": hell world").getBytes());
                        Thread.sleep(2000);
                    }catch (Exception e){

                    }
                }

            }catch (IOException ex){

            }
        }).start();
    }
}
