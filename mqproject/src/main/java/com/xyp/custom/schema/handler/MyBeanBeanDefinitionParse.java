package com.xyp.custom.schema.handler;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class MyBeanBeanDefinitionParse implements BeanDefinitionParser {

    private Class<?> classBean;

    public MyBeanBeanDefinitionParse(Class<?> classBean) {
        super();
        this.classBean = classBean;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {

        RootBeanDefinition bd = new RootBeanDefinition();
        bd.setBeanClass(classBean);
        bd.setLazyInit(false);
        String cla = element.getAttribute("class");
        String name = element.getAttribute("name");
        String id = element.getAttribute("id");
        String scope = element.getAttribute("scope");

        bd.getPropertyValues().addPropertyValue("cla", cla);
        bd.getPropertyValues().addPropertyValue("name", name);
        bd.getPropertyValues().addPropertyValue("id", id);
        bd.getPropertyValues().addPropertyValue("scope", scope);
        parserContext.getRegistry().registerBeanDefinition(id, bd);
        return bd;
    }

}
