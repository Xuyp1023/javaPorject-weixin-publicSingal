/**   
 * @Title: MyParamResolveHandler.java 
 * @Package com.publicSignal.handler 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author xuyp
 * @date 2017年11月6日 上午10:25:39  
 */
package com.publicSignal.handler;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.publicSignal.annocation.MyParam;

/** 
 * @ClassName: MyParamResolveHandler 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xuyp
 * @date 2017年11月6日 上午10:25:39 
 * 如果是myParam注解注释的参数返回值都为null
 *  
 */
public class MyParamResolveHandler implements HandlerMethodArgumentResolver {

    /** 
     * <p>Overriding Method of supportsParameter</p>  
     * <p>Description: </p> 
     * @param anParameter
     * @return 
     * @see org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver#supportsParameter(org.springframework.core.MethodParameter) 
     * @author xuyp
     * @date 2017年11月6日 上午10:28:24 
     */
    @Override
    public boolean supportsParameter(MethodParameter anParameter) {

        return anParameter.hasParameterAnnotation(MyParam.class);
    }

    /** 
     * <p>Overriding Method of resolveArgument</p>  
     * <p>Description: </p> 
     * @param anParameter
     * @param anMavContainer
     * @param anWebRequest
     * @param anBinderFactory
     * @return
     * @throws Exception 
     * @see org.springframework.web.method.support.HandlerMethodArgumentResolver#resolveArgument(org.springframework.core.MethodParameter, org.springframework.web.method.support.ModelAndViewContainer, org.springframework.web.context.request.NativeWebRequest, org.springframework.web.bind.support.WebDataBinderFactory) 
     * @author xuyp
     * @date 2017年11月6日 上午10:43:05 
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String name = parameter.getParameterName();

        // 查找是否已有名为name的参数值的映射，如果没有则创建一个
        Object attribute = mavContainer.containsAttribute(name) ? mavContainer.getModel().get(name)
                : createAttribute(name, parameter, binderFactory, webRequest);

        if (binderFactory != null) {
            WebDataBinder binder = binderFactory.createBinder(webRequest, attribute, name);

            if (binder.getTarget() != null) {
                // 进行参数绑定
                this.bindRequestParameters(binder, webRequest);
            }

            // 将参数转到预期类型，第一个参数为解析后的值，第二个参数为绑定Controller参数的类型，第三个参数为绑定的Controller参数
            attribute = binder.convertIfNecessary(binder.getTarget(), parameter.getParameterType(), parameter);
        }

        return attribute;
    }

    protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request)
            throws UnsupportedEncodingException {
        // 将key-value封装为map，传给bind方法进行参数值绑定
        Map<String, String> map = new HashMap<>();
        Map<String, String[]> params = request.getParameterMap();

        for (Map.Entry<String, String[]> entry : params.entrySet()) {
            String name = entry.getKey();
            // 执行urldecode
            String value = URLDecoder.decode(entry.getValue()[0], "UTF-8");
            map.put(name, value);
        }

        PropertyValues propertyValues = new MutablePropertyValues(map);

        // 将K-V绑定到binder.target属性上
        binder.bind(propertyValues);
    }

    protected Object createAttribute(String attributeName, MethodParameter methodParam,
            WebDataBinderFactory binderFactory, NativeWebRequest request) throws Exception {

        return BeanUtils.instantiateClass(methodParam.getParameterType());
    }

}
