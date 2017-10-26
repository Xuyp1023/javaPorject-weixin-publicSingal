package com.publicSignal.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.junit.Test;

public class NodeCacheTest {
	
	@Test
	public void run() throws Exception{
		
		
		 ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);

	        CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1", retryPolicy);
	        client.start();
	        

	        /**
	         *    NodeCache
	         */
	        NodeCache nodeCache =new  NodeCache(client, "/create/test");
	        nodeCache.start(true);

	        client.setData().forPath("/create/test", "1111".getBytes());

	        System.out.println(new String(nodeCache.getCurrentData().getData()));

	        Thread.sleep(10000);
	        CloseableUtils.closeQuietly(nodeCache);
	        CloseableUtils.closeQuietly(client);
		
	}

}
