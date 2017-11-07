/**   
 * @Title: RabbitMQDirectConsumerEqureReject.java 
 * @Package com.xyp.mq.rabbitmq.consumer 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author xuyp
 * @date 2017年11月7日 上午11:10:48  
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
 * @ClassName: RabbitMQDirectConsumerEqureReject 
 * @Description: 拒绝的消息会重新回到队列，然后再次给别的消费者消费
 * @author xuyp
 * @date 2017年11月7日 上午11:10:48 
 *  
 */
public class RabbitMQDirectConsumerEqureReject {

    private final static String EXCHANGE_NAME = "DIRECT_LOG_ERROR";

    private final static BuiltinExchangeType EXCHANGE_TYPE = BuiltinExchangeType.DIRECT;

    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("127.0.0.1");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);

        // 自定义队列名称
        String queueName = "equre queue confirm";

        // 第一个参数是创建的队列名称 第二个参数（durable）：是否持久化 第三个参数（exclusive）是当前队列是否是这个程序私有的
        // 第四个参数（autoDelete） 当最后一个消费者取消订阅的时候是否需要删除当前队列
        // 第五个参数（arguments） 是参数map
        channel.queueDeclare(queueName, false, false, false, null);

        // 信道绑定队列和routeKey
        channel.queueBind(queueName, EXCHANGE_NAME, "error");

        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String anConsumerTag, Envelope anEnvelope, BasicProperties anProperties,
                    byte[] anBody) throws IOException {
                // 拒绝消息 true：会重新分配给别的消费者 false: 表示这条消息作废
                this.getChannel().basicReject(anEnvelope.getDeliveryTag(), true);
                String message = new String(anBody);
                System.out.println("message...." + message);
                this.getChannel().basicAck(anEnvelope.getDeliveryTag(), false);
            }

        };
        channel.basicConsume(queueName, false, consumer);

    }

}
