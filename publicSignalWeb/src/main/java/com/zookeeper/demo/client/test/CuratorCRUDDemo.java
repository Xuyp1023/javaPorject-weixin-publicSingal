package com.zookeeper.demo.client.test;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

public class CuratorCRUDDemo {

    private static final String ZK_IP_ADDRESS = "192.168.2.55:2181";

    private static final String ZK_CURATOR_BASE_PATH = "/curator-test";

    private CuratorFramework client = null;

    @Before
    public void beforeRun() {

        client = CuratorFrameworkFactory.builder().connectString(ZK_IP_ADDRESS).connectionTimeoutMs(3000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 2)).build();

        client.start();

    }

    @Test
    public void runAdd() throws Exception {

        Stat stat = client.checkExists().forPath(ZK_CURATOR_BASE_PATH);

        if (stat == null) {

            client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL)
                    .forPath(ZK_CURATOR_BASE_PATH, "456".getBytes());
            stat = client.checkExists().forPath(ZK_CURATOR_BASE_PATH);
        }
        // 2463931,2463935,1509095967017,1509096493346,2,0,0,98439571328929577,6,0,2463931
        System.out.println(stat);

    }

    @Test
    /**
     * 节点修改
     * @Title: runUpdate 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @throws Exception TODO(说明)
     * @throws 
     * @author xuyp
     * @date 2017年10月27日 下午5:44:13
     */
    public void runUpdate() throws Exception {

        Stat stat = client.checkExists().forPath(ZK_CURATOR_BASE_PATH);

        if (stat == null) {

            client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL)
                    .forPath(ZK_CURATOR_BASE_PATH, "456".getBytes());
            stat = client.checkExists().forPath(ZK_CURATOR_BASE_PATH);
        }

        client.setData().withVersion(stat.getVersion()).forPath(ZK_CURATOR_BASE_PATH, "789".getBytes());
        System.out.println(new String(client.getData().forPath(ZK_CURATOR_BASE_PATH)));
    }

    @Test
    /**
     * 节点删除
     * @Title: runDelete 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @throws Exception TODO(说明)
     * @throws 
     * @author xuyp
     * @date 2017年10月27日 下午5:48:01
     */
    public void runDelete() throws Exception {

        Stat stat = client.checkExists().forPath(ZK_CURATOR_BASE_PATH);

        if (stat == null) {
            client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL)
                    .forPath(ZK_CURATOR_BASE_PATH, "890".getBytes());
            stat = client.checkExists().forPath(ZK_CURATOR_BASE_PATH);

        }

        client.delete().deletingChildrenIfNeeded().withVersion(stat.getVersion()).forPath(ZK_CURATOR_BASE_PATH);
        System.out.println("删除成功");
    }

}
