package com.publicSignal.countdown;

import java.util.concurrent.CountDownLatch;

public class NetworkServiceVerity extends HealthVerity {

	
	public NetworkServiceVerity(String serviceName, CountDownLatch cdl) {
		super(serviceName, cdl);
		// TODO Auto-generated constructor stub
	}

	@Override
	void verityCheck() {
		System.out.println("serviceName" + super.getServiceName() + " run over");
		
		try {
			Thread.sleep(700L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
