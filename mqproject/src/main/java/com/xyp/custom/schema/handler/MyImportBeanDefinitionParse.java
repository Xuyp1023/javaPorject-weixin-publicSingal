package com.xyp.custom.schema.handler;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class MyImportBeanDefinitionParse implements BeanDefinitionParser {

    private Class<?> classBean;

    public MyImportBeanDefinitionParse(Class<?> classBean) {

        this.classBean = classBean;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {

        RootBeanDefinition bd = new RootBeanDefinition();
        bd.setBeanClass(classBean);
        bd.setLazyInit(false);
        String resource = element.getAttribute("resource");
        String profile = element.getAttribute("profile");
        String encord = element.getAttribute("encord");

        bd.getPropertyValues().addPropertyValue("encord", encord);
        bd.getPropertyValues().addPropertyValue("profile", profile);
        bd.getPropertyValues().addPropertyValue("resource", resource);
        parserContext.getRegistry().registerBeanDefinition(resource, bd);
        return bd;
    }

}
