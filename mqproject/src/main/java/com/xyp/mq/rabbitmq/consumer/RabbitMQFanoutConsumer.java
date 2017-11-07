/**   
 * @Title: RabbitMQFanoutConsumer.java 
 * @Package com.xyp.mq.rabbitmq.consumer 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author xuyp
 * @date 2017年11月7日 上午9:09:08  
 */
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
 * @ClassName: RabbitMQFanoutConsumer 
 * @Description: fanout 广播消息消费   无法指定特定的消费routkey  只会消费这个队列上所有的信息 
 * @author xuyp
 * @date 2017年11月7日 上午9:09:08 
 *  
 */
public class RabbitMQFanoutConsumer {

    private final static String EXCHANGE_NAME = "fatout_log";

    private final static BuiltinExchangeType EXCHANGE_TYPE = BuiltinExchangeType.FANOUT;

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);

        String queueName = channel.queueDeclare().getQueue();

        channel.queueBind(queueName, EXCHANGE_NAME, "error");

        System.out.println(" waiting message fanout ");
        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String anConsumerTag, Envelope anEnvelope, BasicProperties anProperties,
                    byte[] anBody) throws IOException {

                String message = new String(anBody);

                System.out.println("fanout consumer message =" + message);

            }

        };

        channel.basicConsume(queueName, true, consumer);

    }

}
