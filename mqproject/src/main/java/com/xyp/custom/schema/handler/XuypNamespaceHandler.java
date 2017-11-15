package com.xyp.custom.schema.handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class XuypNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {

        registerBeanDefinitionParser("myBean", new MyBeanBeanDefinitionParse(MyBeanConfigBean.class));
        registerBeanDefinitionParser("myImport", new MyImportBeanDefinitionParse(MyImortConfigBean.class));

    }

}
