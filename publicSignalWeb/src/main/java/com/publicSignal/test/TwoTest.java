package com.publicSignal.test;

import org.springframework.stereotype.Repository;

@Repository
public class TwoTest implements NumberTest{

    @Override
    public void run() {
        System.out.println("two...run");
        
    }

}
