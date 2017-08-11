package com.publicSignal.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.publicSignal.mapper.PublicSignalEffectiveLog;
import com.publicSignal.service.PublicSignalEffectiveLogService;
import com.publicSignal.util.AjaxObject;
import com.publicSignal.util.ProcessHandler;
import com.publicSignal.util.ProcessHandler.ExceptionHandler;

@RestController
@RequestMapping("/EffectiveLog")
public class EffectiveLogController {
    
    private static final Logger logger = LoggerFactory.getLogger(EffectiveLogController.class);
    @Autowired
    private PublicSignalEffectiveLogService publicSignalEffectiveLogService;
    
    @RequestMapping(value="/saveAddLog",method=RequestMethod.POST)
    public String saveAdd(HttpServletRequest request,PublicSignalEffectiveLog effectiveLog){
        
        System.out.println(effectiveLog);
        String value=ProcessHandler.exec(new ExceptionHandler() {
            
            @Override
            public Object handle() {
                
                return publicSignalEffectiveLogService.saveAddLog(effectiveLog);
            }
        }
        , "新增登录信息出错", logger);
        return value;
    }
    
    @RequestMapping("/test")
    public String testUrl(){
        
        System.out.println("test...");
        return "test";
        
    }

}
