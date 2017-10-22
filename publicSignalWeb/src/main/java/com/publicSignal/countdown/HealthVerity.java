package com.publicSignal.countdown;

import java.util.concurrent.CountDownLatch;

public abstract class HealthVerity implements Runnable{
	
	private String serviceName;
	
	private CountDownLatch cdl;
	
	abstract void verityCheck();

	public HealthVerity(String serviceName, CountDownLatch cdl) {
		super();
		this.serviceName = serviceName;
		this.cdl = cdl;
	}



	public HealthVerity() {
		super();
		
	}



	public String getServiceName() {
		return serviceName;
	}



	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}



	public CountDownLatch getCdl() {
		return cdl;
	}



	public void setCdl(CountDownLatch cdl) {
		this.cdl = cdl;
	}



	@Override
	public void run() {
		
		verityCheck();
		
		if(cdl !=null){
			cdl.countDown();
		}
		
	}

}
