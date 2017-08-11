package com.publicSignal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.publicSignal.mapper.PublicSignalEffectiveLog;
import com.publicSignal.mapper.PublicSignalEffectiveLogMapper;
import com.publicSignal.service.PublicSignalEffectiveLogService;

@Service
public class PublicSignalEffectiveLogServiceImpl implements PublicSignalEffectiveLogService {

    @Autowired
    private PublicSignalEffectiveLogMapper effectiveLogMapper;
    @Override
    public PublicSignalEffectiveLog saveAddLog(PublicSignalEffectiveLog anEffectiveLog) {
        
        System.out.println("bbbb");
        try {
            int i=effectiveLogMapper.saveAddLog(anEffectiveLog);
            System.out.println(i);
            System.out.println(anEffectiveLog.toString());
            return anEffectiveLog;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return new PublicSignalEffectiveLog();
    }

}
