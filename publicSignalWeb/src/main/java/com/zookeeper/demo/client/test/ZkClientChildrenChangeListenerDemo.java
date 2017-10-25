package com.zookeeper.demo.client.test;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;
import org.junit.Test;

/**
 * 当前方法测试子节点监听器相关特性
 * 当新增子节点时 会触发ZkClientChildrenChangeListener
 * 当修改子节点的值或者删除子节点时不会触发当前Listener
 * @ClassName: ZkClientChildrenChangeListenerDemo 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xuyp
 * @date 2017年10月25日 下午5:41:42 
 *
 */
public class ZkClientChildrenChangeListenerDemo {

    private final static String ZKCLIENT_TEST_BASE_PATH = "/zk-test";

    private final static String ZKCLIENT_TEST_SERVICE_PATH_PORT = "192.168.2.55:2181";

    @Test
    public void run() {

        // 获取zkClient对象
        ZkClient zk = new ZkClient(ZKCLIENT_TEST_SERVICE_PATH_PORT, 5000);

        // 注册子节点监听器
        subscribeChildChangesListener(zk);

        if (zk.exists(ZKCLIENT_TEST_BASE_PATH)) {

            zk.delete(ZKCLIENT_TEST_BASE_PATH + "/child");
            zk.createPersistent(ZKCLIENT_TEST_BASE_PATH + "/child", "456");
        } else {
            zk.createPersistent(ZKCLIENT_TEST_BASE_PATH, "123");
            zk.createPersistent(ZKCLIENT_TEST_BASE_PATH + "/child", "456");
        }
        Object readData = zk.readData(ZKCLIENT_TEST_BASE_PATH + "/child");
        System.out.println(readData);
    }

    @Test
    /**
     * 不会触发
     * @Title: runChildNodeUpdate 
     * @Description: TODO(这里用一句话描述这个方法的作用)  TODO(说明)
     * @throws 
     * @author xuyp
     * @date 2017年10月25日 下午5:52:20
     */
    public void runChildNodeUpdate() {

        // 获取zkClient对象
        ZkClient zk = new ZkClient(ZKCLIENT_TEST_SERVICE_PATH_PORT, 5000);

        // 注册子节点监听器
        subscribeChildChangesListener(zk);

        zk.writeData(ZKCLIENT_TEST_BASE_PATH + "/child", "789");

        Object readData = zk.readData(ZKCLIENT_TEST_BASE_PATH + "/child");
        System.out.println(readData);

    }

    @Test
    /**
     * 不会触发
     * @Title: runChildNodeDelete 
     * @Description: TODO(这里用一句话描述这个方法的作用)  TODO(说明)
     * @throws 
     * @author xuyp
     * @date 2017年10月25日 下午5:56:08
     */
    public void runChildNodeDelete() {

        // 获取zkClient对象
        ZkClient zk = new ZkClient(ZKCLIENT_TEST_SERVICE_PATH_PORT, 5000);

        // 注册子节点监听器
        subscribeChildChangesListener(zk);

        System.out.println(zk.delete(ZKCLIENT_TEST_BASE_PATH + "/child"));
        // System.out.println(zk.readData(ZKCLIENT_TEST_BASE_PATH + "/child"));

    }

    private void subscribeChildChangesListener(ZkClient zk) {
        zk.subscribeChildChanges(ZKCLIENT_TEST_BASE_PATH, new IZkChildListener() {

            @Override
            public void handleChildChange(String arg0, List<String> arg1) throws Exception {

                System.out.println("子节点监听器" + arg0 + "    " + arg1);

            }
        });
    }
}
