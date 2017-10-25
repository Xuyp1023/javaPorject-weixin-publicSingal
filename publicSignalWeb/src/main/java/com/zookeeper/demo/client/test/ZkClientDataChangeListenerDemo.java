package com.zookeeper.demo.client.test;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.junit.Test;

/**
 * zkClient 监听节点数据更改时候的时间 当该节点数据更改或者删除时会自动调用事件中的方法
 * @ClassName: ZkClientDataChangeListenerDemo 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xuyp
 * @date 2017年10月25日 下午5:21:41 
 *
 */
public class ZkClientDataChangeListenerDemo {

    private final static String ZKCLIENT_TEST_BASE_PATH = "/zk-test";

    private final static String ZKCLIENT_TEST_SERVICE_PATH_PORT = "192.168.2.55:2181";

    /**
     * 当节点更新或者删除时会调用subscribeDataChanges 事件监听
     * @Title: run 
     * @Description: TODO(这里用一句话描述这个方法的作用)  TODO(说明)
     * @throws 
     * @author xuyp
     * @date 2017年10月25日 下午5:23:03
     */
    @Test
    public void run() {

        // 获取到zkClient对象
        ZkClient zk = new ZkClient(ZKCLIENT_TEST_SERVICE_PATH_PORT, 5000);

        // 注册修改删除监听时间
        subscribeDataChangesListener(zk);

        // 如果节点存在，先删除
        if (zk.exists(ZKCLIENT_TEST_BASE_PATH)) {
            boolean deleteFlag = zk.delete(ZKCLIENT_TEST_BASE_PATH);
            System.out.println("节点已经存在，现在删除" + deleteFlag);
        }

        zk.createPersistent(ZKCLIENT_TEST_BASE_PATH, "123");

        // 注册修改删除监听时间
        // subscribeDataChangesListener(zk);

        zk.writeData(ZKCLIENT_TEST_BASE_PATH, "456");

        Object data = zk.readData(ZKCLIENT_TEST_BASE_PATH);

        System.out.println("读取zk 的值" + data);

    }

    /**
     * 当添加子节点时是不会触发当前事件的
     * @Title: runNodeSon 
     * @Description: TODO(这里用一句话描述这个方法的作用)  TODO(说明)
     * @throws 
     * @author xuyp
     * @date 2017年10月25日 下午5:39:46
     */
    @Test
    public void runNodeSon() {

        // 获取到zkClient对象
        ZkClient zk = new ZkClient(ZKCLIENT_TEST_SERVICE_PATH_PORT, 5000);

        // 注册subscribeDataChangesListener监听事件
        subscribeDataChangesListener(zk);

        // 往节点插入临时节点子节点
        if (zk.exists(ZKCLIENT_TEST_BASE_PATH)) {
            System.out.println("创建临时子节点");
            zk.createEphemeral(ZKCLIENT_TEST_BASE_PATH + "/e123", "456789");
            System.out.println("创建临时子节点完成");

        }

        // 往节点插入持久节点子节点
        if (zk.exists(ZKCLIENT_TEST_BASE_PATH)) {
            System.out.println("创建持久子节点");
            zk.createPersistent(ZKCLIENT_TEST_BASE_PATH + "/p123", "456789");
            System.out.println("创建子持久节点完成");

        }

    }

    private void subscribeDataChangesListener(ZkClient zk) {
        zk.subscribeDataChanges(ZKCLIENT_TEST_BASE_PATH, new IZkDataListener() {

            @Override
            public void handleDataDeleted(String basePath) throws Exception {
                System.out.println("数据删除的监听器" + basePath);

            }

            @Override
            public void handleDataChange(String basePath, Object data) throws Exception {
                System.out.println("数据改变的监听器" + basePath + "......arg1" + data);

            }
        });
    }
}
