package com.xyp.mq.rabbitmq.product;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQDirectProduct {

    private static final String EXCHANGE_NAME = "direct_log";

    private static final BuiltinExchangeType EXCHANGE_TYPE = BuiltinExchangeType.DIRECT;

    public static void main(String[] args) throws Exception {

        // 1:创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("127.0.0.1");
        // 默认可以不写
        factory.setUsername(ConnectionFactory.DEFAULT_USER);
        factory.setPort(ConnectionFactory.DEFAULT_AMQP_PORT);
        factory.setVirtualHost(ConnectionFactory.DEFAULT_VHOST);
        // 2 创建连接
        Connection connection = factory.newConnection();
        // 3 创建信道
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);

        String[] serverList = { "error", "info", "warning" };
        for (int i = 0; i < serverList.length; i++) {
            String server = serverList[i];
            String message = "HelloWorld_" + (i + 1);

            // 4：往特定的信道发送指定的路由键的消息
            channel.basicPublish(EXCHANGE_NAME, server, null, message.getBytes());
            System.out.println("Send " + server + ":" + message);

        }

        channel.close();
        connection.close();
    }

}
