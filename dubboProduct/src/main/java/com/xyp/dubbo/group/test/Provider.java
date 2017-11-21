package com.xyp.dubbo.group.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

    public static void main(final String[] args) throws Exception {

        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring/applicationContext-dubbo.xml" });
        context.start();
        // testMOdifyCorpAccount(context);
        System.out.println("Provider working");
        System.in.read();
        context.close();
        System.exit(0);
    }

}
