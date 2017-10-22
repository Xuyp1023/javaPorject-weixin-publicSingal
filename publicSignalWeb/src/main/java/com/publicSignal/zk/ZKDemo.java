package com.publicSignal.zk;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

public class ZKDemo implements Watcher {
	private static final CountDownLatch cdl = new CountDownLatch(1);

	public static void main(String[] args) throws IOException, Exception, InterruptedException {
		ZooKeeper zk = new ZooKeeper("192.168.92.130:2185", 5000, new ZKDemo());

		System.out.println(zk.getState());
		try {
			cdl.await();
		} catch (Exception e) {
			System.out.println("ZK Session established.");
		}
		Stat stat = zk.exists("/zk-test", new ZKDemo());
		if(stat ==null){
			String string = zk.create("/zk-test", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			System.out.println(string);
		}else{
			System.out.println(stat);
			System.out.println(stat.getVersion());
			byte[] data = zk.getData("/zk-test", null, stat);
			System.out.println(new String(data));
			zk.setData("/zk-test", "234".getBytes(), stat.getVersion());
			byte[] data2 = zk.getData("/zk-test", null, stat);
			System.out.println(new String(data2));
		}
	}

	@Override
	public void process(WatchedEvent event) {
		System.out.println("Receive watched event:" + event);
		if (KeeperState.SyncConnected == event.getState()) {
			cdl.countDown();
		}
	}
	
	@Test
	public void run(){
		
		System.out.println("123");
		System.out.println(cdl.getCount());
		try {
			cdl.countDown();
			cdl.countDown();
			cdl.await(10L,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("456");
		
	}
	
}
