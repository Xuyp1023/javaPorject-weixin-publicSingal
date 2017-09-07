package com.publicSignal.service.impl.man;

import org.junit.Test;

/**
 * 用来测试 重载参数的编译时机
 * @author xuyp
 *
 */
public class ManTest {
    
    public void say(Human man){
        
        System.out.println("Human........");
        
    }
    
    public void say(Man man){
        
        System.out.println("Man........");
        
    }
    
    public void say(Woman man){
        
        System.out.println("Woman........");
        
    }
    
    @Test
    public void run(){
        
        Human man=new Man();
        
        Human woman=new Woman();
        
        say(man);
        say(woman);
        
    }

}
