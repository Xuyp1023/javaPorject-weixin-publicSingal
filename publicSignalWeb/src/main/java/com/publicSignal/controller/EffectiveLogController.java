package com.publicSignal.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.publicSignal.certifiont.authority.PermissionRequest;
import com.publicSignal.mapper.PublicSignalEffectiveLog;
import com.publicSignal.util.ProcessHandler;
import com.publicSignal.util.ProcessHandler.ExceptionHandler;

@RestController
@RequestMapping("/EffectiveLog")
public class EffectiveLogController /*implements BeanFactoryAware, BeanDefinitionRegistryPostProcessor, Ordered*/ {

    private static final Logger logger = LoggerFactory.getLogger(EffectiveLogController.class);
    /*@Autowired
    private PublicSignalEffectiveLogService publicSignalEffectiveLogService;*/

    @RequestMapping(value = "/saveAddLog", method = RequestMethod.POST)
    @PermissionRequest(permissionRrequestCode = "user")
    @ResponseBody
    public String saveAdd(HttpServletRequest request, PublicSignalEffectiveLog effectiveLog) {

        System.out.println(effectiveLog);
        String value = ProcessHandler.exec(new ExceptionHandler() {

            @Override
            public Object handle() {

                // return publicSignalEffectiveLogService.saveAddLog(effectiveLog);
                return "123";
            }
        }, "新增登录信息出错", logger);
        return value;
    }

    @RequestMapping("/test")
    @PermissionRequest(permissionRrequestCode = "userAdd")
    public String testUrl() {

        System.out.println("test...");
        return "test";

    }

    @RequestMapping("/testAnnocation")
    @ResponseBody
    public String testUrlNoAnnocation() {

        System.out.println("testAnnocation...");
        return "testAnnocation";

    }

    /* public static void main(String[] args) throws JsonProcessingException {
    
        PublicSignalEffectiveLog log = new PublicSignalEffectiveLog();
        log.setAppid("123dsfd");
        log.setBusinStatus("2");
        log.setId(123l);
        log.setOpenid("dafdafdasfasd");
        log.setPersionId(213213123l);
        ObjectMapper mapper = new CustomMapper();
        String string = mapper.writeValueAsString(log);
        System.out.println(string);
    
    }
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    
    }
    
    @Override
    public int getOrder() {
    
        return 0;
    }
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // TODO Auto-generated method stub
    
    }
    
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    
        BeanDefinition beanDefinition = registry.getBeanDefinition("student");
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
        // propertyValues.get
    
    }
    
    @Test
    public void run() {
    
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext();
    
    }
    */
}
