package com.publicSignal.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface PublicSignalEffectiveLogMapper {
    
    public int saveAddLog(PublicSignalEffectiveLog effectiveLog);

}
