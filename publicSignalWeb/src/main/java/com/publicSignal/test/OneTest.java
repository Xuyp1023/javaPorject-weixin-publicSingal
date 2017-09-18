package com.publicSignal.test;

import org.springframework.stereotype.Service;

@Service
public class OneTest implements NumberTest{
    
    public void run(){
        System.out.println("one Test");
    }

}
