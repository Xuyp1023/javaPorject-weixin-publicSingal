package com.publicSignal.countdown;

import java.util.concurrent.CountDownLatch;

public class CacheServiceVerity extends HealthVerity {

	
	public CacheServiceVerity(String serviceName, CountDownLatch cdl) {
		super(serviceName, cdl);
	}

	@Override
	void verityCheck() {
		System.out.println("serviceName :" + super.getServiceName() + " run over");
		
		try {
			Thread.sleep(700L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
