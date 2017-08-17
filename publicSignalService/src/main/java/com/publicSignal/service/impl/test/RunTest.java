package com.publicSignal.service.impl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value={"classpath:spring/test-application.xml"})
@Service
public class RunTest implements BeanDefinitionRegistryPostProcessor,Ordered {

    private static  ConfigurableListableBeanFactory context;
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory anBeanFactory) throws BeansException {
        context=anBeanFactory;
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry anRegistry) throws BeansException {
        
        BeanDefinition definition = anRegistry.getBeanDefinition("myOne");
        MutablePropertyValues propertyValues = definition.getPropertyValues();
        propertyValues.addPropertyValue("userName", "xiaosan");
        propertyValues.addPropertyValue("age", 12);
        Object age = propertyValues.get("age");
        propertyValues.addPropertyValue("age", 13+Integer.parseInt(age.toString()));
    }
    
    @Test
    public void run(){
        
        MyOne one = context.getBean(MyOne.class);
        System.out.println(one);
        
    }

}
