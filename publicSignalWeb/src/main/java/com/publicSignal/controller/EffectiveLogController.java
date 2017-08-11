package com.publicSignal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.publicSignal.mapper.PublicSignalEffectiveLog;
import com.publicSignal.service.PublicSignalEffectiveLogService;

@RestController
@RequestMapping("/EffectiveLog")
public class EffectiveLogController {
    
    
    @Autowired
    private PublicSignalEffectiveLogService publicSignalEffectiveLogService;
    
    @RequestMapping(value="/saveAddLog",method=RequestMethod.POST)
    public String saveAdd(HttpServletRequest request,PublicSignalEffectiveLog effectiveLog){
        
        System.out.println(effectiveLog);
        return publicSignalEffectiveLogService.saveAddLog(effectiveLog).toString();
    }
    
    @RequestMapping("/test")
    public String testUrl(){
        
        System.out.println("test...");
        return "test";
        
    }

}
