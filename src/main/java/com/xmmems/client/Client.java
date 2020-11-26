package com.xmmems.client;

import com.xmmems.common.exception.XMException;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class Client {
    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = Integer.parseInt(System.getProperty("port", "6690"));
    static final int SIZE = Integer.parseInt(System.getProperty("size", "2056"));

    public static void main(String[] args) {

        sendMessage("##0561QN=20201030000000437;ST=21;CN=2061;PW=123456;MN=NM100000_0005;Flag=9;CP=&&DataTime=20201129210001;w01010-Avg=23.1,w01010-Flag=N;w01001-Avg=7.64,w01001-Flag=N;w01009-Avg=6.60,w01009-Flag=N;w01014-Avg=300,w01014-Flag=N;w01003-Avg=17,w01003-Flag=N;w01019-Avg=1.4,w01019-Flag=N;w21011-Avg=0.042,w21011-Flag=N;w21001-Avg=3.04,w21001-Flag=N;w21003-Avg=0.16,w21003-Flag=N;w20120-Avg=0.00011,w20120-Flag=N;w20119-Avg=0.00000,w20119-Flag=N;w23002-Avg=0.0005,w23002-Flag=N;w21016-Avg=0.002,w21016-Flag=N;w20115-Avg=0.00001,w20115-Flag=N;w20122-Avg=0.00005,w20122-Flag=N&&4C80\r\n");
       }


    public static void sendMessage(String content) {
        // Configure the client.
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch) {
                            ChannelPipeline p = ch.pipeline();
                            p.addLast("decoder", new StringDecoder());
                            p.addLast("encoder", new StringEncoder());
                            p.addLast(new ClientHandler());
                        }
                    });

            ChannelFuture future = b.connect(HOST, PORT).sync();
            future.channel().writeAndFlush(content);
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            throw new XMException(500, e.getMessage());
        } finally {
            group.shutdownGracefully();
        }
    }

}