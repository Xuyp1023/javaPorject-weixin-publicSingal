package com.xyp.mq.rabbitmq.consumer;

import java.io.IOException;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class RabbitMQDirectConsumer {

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
        // 声明随机队列
        String queueName = channel.queueDeclare().getQueue();

        String[] serverList = { "error", "info", "warning" };
        for (String server : serverList) {
            // 4: 队列和交换器的绑定
            channel.queueBind(queueName, EXCHANGE_NAME, server);
        }

        System.out.println("waiting message.......");
        // 定义消费者
        Consumer consumerA = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
                    throws IOException {

                String message = new String(body);
                System.out.println("Accepp: message= " + message);
            }

        };
        // 消费者指定消费信道 并且设置为自动应答
        channel.basicConsume(queueName, true, consumerA);
    }

}
