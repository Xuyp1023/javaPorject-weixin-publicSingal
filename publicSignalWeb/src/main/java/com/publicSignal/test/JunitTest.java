package com.publicSignal.test;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:test/springmvcTest.xml"})
public class JunitTest implements ApplicationContextAware{
    
    /*@Autowired
    private OneTest one;*/
    
    private  ApplicationContext anApplicationContext=null;
    
    @Test
    public void run(){
        //OneTest test = anApplicationContext.getBean(OneTest.class);
        String[] oneTestList = anApplicationContext.getBeanNamesForType(NumberTest.class, true, false);
        for (String one : oneTestList) {
            NumberTest test = anApplicationContext.getBean(one, NumberTest.class);
            test.run();
        }
        
        if(anApplicationContext.isTypeMatch("oneTest", NumberTest.class)){
            
          System.out.println("oneTest  is NumberTest");  
            
        }
        
        Map<String, NumberTest> map = anApplicationContext.getBeansOfType(NumberTest.class);
        for(String key:map.keySet()){
            System.out.println("key="+key+"  value="+map.get(key));
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext anApplicationContext) throws BeansException {
        
        this.anApplicationContext=anApplicationContext;
    }

}
