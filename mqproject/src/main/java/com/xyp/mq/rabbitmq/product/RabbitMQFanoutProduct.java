/**   
 * @Title: RabbitMQFatoutProduct.java 
 * @Package com.xyp.mq.rabbitmq.product 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author xuyp
 * @date 2017年11月7日 上午8:52:37  
 */
package com.xyp.mq.rabbitmq.product;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/** 
 * @ClassName: RabbitMQFatoutProduct 
 * @Description: 用于测试 广播方式
 * @author xuyp
 * @date 2017年11月7日 上午8:52:37 
 *  
 */
public class RabbitMQFanoutProduct {

    private static final String EXCHANGE_NAME = "fatout_log";

    private static final BuiltinExchangeType EXCHANGE_TYPE = BuiltinExchangeType.FANOUT;

    public static void main(String[] args) throws Exception {

        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("127.0.0.1");

        // 获取连接
        Connection connection = factory.newConnection();

        // 创建信道
        Channel channel = connection.createChannel();

        // 绑定信道 类型以及交换器名称
        channel.exchangeDeclare(EXCHANGE_NAME, EXCHANGE_TYPE);

        String[] routeKeyList = { "error", "info", "debug" };

        for (int i = 0; i < routeKeyList.length; i++) {
            String routeKey = routeKeyList[i];
            String message = "rabbitmq fanout message" + (i + 1);
            // 发送消息到指定的路由建
            channel.basicPublish(EXCHANGE_NAME, routeKey, null, message.getBytes());
            System.out.println("fanout product send" + message);
        }

        // 关闭信道已经连接
        channel.close();
        connection.close();

    }

}
