package com.publicSignal.util;

import org.slf4j.Logger;
import com.alibaba.dubbo.rpc.RpcException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.publicSignal.exception.PublicSignalException;

public class ProcessHandler {
    
    private static ObjectMapper mapper=new CustomMapper();
    
    public static String toJson(Object obj){
        
        try{
            return mapper.writeValueAsString(obj);
        }catch(Exception e){
            
            return "";
            
        }
        
    }
    public static String exec(ExceptionHandler run,String errorMessage,Logger logger){
        try {
            Object object = run.handle();
            System.out.println("json...."+object);
            return ProcessHandler.toJson(object);
        }
        catch (RpcException btEx) {
            if (PublicSignalException.isCauseBytterException(btEx)) {
                logger.error(btEx.getMessage(), btEx);
                
                return ProcessHandler.toJson(AjaxObject.newError(btEx.getCause().getMessage()));
            }
            logger.error(btEx.getMessage(), btEx);
            return ProcessHandler.toJson(AjaxObject.newError(errorMessage));
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return ProcessHandler.toJson(AjaxObject.newError(errorMessage));
        }
        
    }
    
    public static interface ExceptionHandler{
        public Object handle();
    }

}
