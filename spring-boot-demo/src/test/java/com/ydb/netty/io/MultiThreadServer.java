package com.ydb.netty.io;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @Author ligeng
 * @Date 19/6/22
 * @Time 下午9:10
 */
public class MultiThreadServer {
    public static void main(String[] args) {
        try(ServerSocket server=new ServerSocket(8888)){
            while(true) {
                try {
                    Socket client = server.accept();
                    Thread task = new TimeThread(client);
                    task.start();

                } catch (IOException ex) {
                    //忽略连接异常
                }
            }
        }catch (IOException ex){//端口占用或者无权使用将抛出异常
            System.err.println(ex);
        }
    }

    private static class TimeThread extends Thread{
        private Socket client;

        public TimeThread(Socket client){
            this.client=client;
        }

        @Override
        public void run(){
            try{
                Writer out=new OutputStreamWriter(client.getOutputStream());
                Date now=new Date();
                out.write(now.toString()+"\r\n");
                //时间协议，添加不依赖于平台的换行符
                out.flush();
                out.close();

            }catch (IOException ex){
                System.err.println(ex);
            }finally {
                try {
                    client.close();
                }catch (IOException ex){
                    //忽略
                }
            }
        }
    }


}
