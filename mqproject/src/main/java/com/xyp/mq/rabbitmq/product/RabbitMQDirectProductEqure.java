/**   
 * @Title: RabbitMQDirectProductEqure.java 
 * @Package com.xyp.mq.rabbitmq.product 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author xuyp
 * @date 2017年11月7日 上午10:33:12  
 */
package com.xyp.mq.rabbitmq.product;

import java.io.IOException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/** 
 * @ClassName: RabbitMQDirectProductEqure 
 * @Description: 用于生成一致的消息
 * @author xuyp
 * @date 2017年11月7日 上午10:33:12 
 *  
 */
public class RabbitMQDirectProductEqure {

    private final static String EXCHANGE_NAME = "DIRECT_LOG_ERROR";

    private final static BuiltinExchangeType EXCHANGE_TYPE = BuiltinExchangeType.DIRECT;

    /** 
     * @Title: main 
     * @Description:
     * @param args 参数说明 
     * @throws Exception 
     * @throws IOException 
     * @throws 
     * @author xuyp
     * @date 2017年11月7日 上午10:33:12 
     */
    public static void main(String[] args) throws IOException, Exception {

        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("127.0.0.1");

        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);

        for (int i = 0; i < 10; i++) {

            String message = "send  helloworld _error" + i;
            channel.basicPublish(EXCHANGE_NAME, "error", null, message.getBytes());
            System.out.println(message);
        }

        channel.close();
        connection.close();

    }

}
