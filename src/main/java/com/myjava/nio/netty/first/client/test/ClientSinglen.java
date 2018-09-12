package com.myjava.nio.netty.first.client.test;

import com.myjava.nio.netty.first.client.ClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by flyap on 2018/8/23.
 */
public class ClientSinglen {

    public static void main(String[] args){
        //服务
        Bootstrap bootstrap=new Bootstrap();
        //worker
        EventLoopGroup worker=new NioEventLoopGroup();
        //设置线程池
        bootstrap.group(worker);
        //设置socket 工厂
        bootstrap.channel(NioSocketChannel.class);
        //设置管道
        bootstrap.handler(
                new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new StringEncoder());
                        ch.pipeline().addLast(new ClientHandler());
                    }
                });
        ChannelFuture connet=bootstrap.connect("127.0.0.1",10101);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("请输入：");
            String msg= null;
            try {
                msg = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                worker.shutdownGracefully();
            }
            connet.channel().write(msg);
        }


    }








}
