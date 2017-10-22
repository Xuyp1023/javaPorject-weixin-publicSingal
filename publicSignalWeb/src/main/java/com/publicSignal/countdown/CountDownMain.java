package com.publicSignal.countdown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.junit.Test;

public class CountDownMain {

	private static CountDownLatch cdl;
	public void runOne() throws Exception {
		
		cdl = new CountDownLatch(3);
		List<HealthVerity> services=new ArrayList<>();
		services.add(new CacheServiceVerity("cacheservice", cdl));
		services.add(new DbServiceVerity("dbservice", cdl));
		services.add(new NetworkServiceVerity("networkservice", cdl));
		Executor executor = Executors.newFixedThreadPool(services.size());
		for (HealthVerity healthVerity : services) {
			executor.execute(healthVerity);
		}
		
		cdl.await();
		System.out.println(cdl.getCount());
		System.out.println("over");
		
	}
	
	@Test
	public void run() throws Exception{
		runOne();
	}

}
