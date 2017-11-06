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

/**
 * 
 * @ClassName: RabbitMQDirectConsumerError 
 * @Description: 只消费指定路由key的消息
 * @author lenovo
 * @date 2017年11月6日 下午11:49:40 
 *
 */
public class RabbitMQDirectConsumerError {

    private final static String EXCHANGE_NAME = "direct_log";

    private final static BuiltinExchangeType EXCHANGE_TYPE = BuiltinExchangeType.DIRECT;

    public static void main(String[] args) throws Exception {
        // 获取工厂
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("127.0.0.1");
        // 获取连接
        Connection connection = factory.newConnection();
        // 获取信道
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);
        // 获取队列名称
        String queueName = channel.queueDeclare().getQueue();

        // 信道绑定路由key
        channel.queueBind(queueName, EXCHANGE_NAME, "error");

        System.out.println("waitingmessage....error....");

        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body);
                System.out.println("Accepp: message= " + message);
            }

        };

        // 消费者指定消费信道 并且设置为自动应答
        channel.basicConsume(queueName, true, consumer);

    }

}
