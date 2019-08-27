package com.example.rabbitmq.simple;

import com.example.rabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class SimpleSend {
    public static final String QUEUE_NAME = "simple_queue";
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取链接
        Connection connection = ConnectionUtil.getConnection();
        //创建信道
        Channel channel = connection.createChannel();
        //声明队列
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        String msg = "simple to msg";
        channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
        System.out.println("simple ......");
        channel.close();
        connection.close();
    }
}
