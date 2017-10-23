package com.publicSignal.common.config.properties;

import java.lang.reflect.Method;
import java.util.Properties;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PropertiesLoaderSupport;

import com.betterjr.common.service.SpringContextHolder;

public class SpringPropertyResourceReader {
    private static Properties properties = new Properties();
    static {
        try {
            // get the names of BeanFactoryPostProcessor
            final String[] postProcessorNames = SpringContextHolder.getApplicationContext()
                    .getBeanNamesForType(BeanFactoryPostProcessor.class, true, true);

            for (final String ppName : postProcessorNames) {
                // get the specified BeanFactoryPostProcessor
                final BeanFactoryPostProcessor beanProcessor = SpringContextHolder.getApplicationContext()
                        .getBean(ppName, BeanFactoryPostProcessor.class);
                // check whether the beanFactoryPostProcessor is
                // instance of the PropertyResourceConfigurer
                // if it is yes then do the process otherwise continue
                if (beanProcessor instanceof PropertySourcesPlaceholderConfigurer) {
                    final PropertyResourceConfigurer propertyResourceConfigurer = (PropertyResourceConfigurer) beanProcessor;

                    // get the method mergeProperties
                    // in class PropertiesLoaderSupport
                    final Method mergeProperties = PropertiesLoaderSupport.class.getDeclaredMethod("mergeProperties");
                    // get the props
                    mergeProperties.setAccessible(true);
                    final Properties props = (Properties) mergeProperties.invoke(propertyResourceConfigurer);

                    // get the method convertProperties
                    // in class PropertyResourceConfigurer
                    final Method convertProperties = PropertyResourceConfigurer.class
                            .getDeclaredMethod("convertProperties", Properties.class);
                    // convert properties
                    convertProperties.setAccessible(true);
                    convertProperties.invoke(propertyResourceConfigurer, props);

                    properties.putAll(props);
                }
            }

        }
        catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(final String anPropertyName, final String anDefaultValue) {
        final String value = properties.getProperty(anPropertyName);
        return value != null ? value : anDefaultValue;
    }
}