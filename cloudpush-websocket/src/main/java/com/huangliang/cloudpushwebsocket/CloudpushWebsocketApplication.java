package com.huangliang.cloudpushwebsocket;

import com.huangliang.cloudpushwebsocket.netty.Server;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudpushWebsocketApplication implements CommandLineRunner {

    @Autowired
    private Server socketServer;

    public static void main(String[] args) {
        init();
        SpringApplication.run(CloudpushWebsocketApplication.class, args);
    }

    @Override
    public void run(String... args){

        ChannelFuture future = socketServer.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> socketServer.destroy()));
        future.channel().closeFuture().syncUninterruptibly();
    }

    private static void init(){
        //根据网卡动态设置ip（为了将netty的ip:port维护进redis）

    }
}
