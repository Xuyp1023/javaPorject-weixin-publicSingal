package com.publicSignal.util;

import org.slf4j.Logger;
import com.alibaba.dubbo.rpc.RpcException;
import com.publicSignal.exception.PublicSignalException;

public class ProcessHandler {
    
    public static String exec(ExceptionHandler run,String errorMessage,Logger logger){
        try {
            return AjaxObject.newOk(run.handle()).toJson();
        }
        catch (RpcException btEx) {
            if (PublicSignalException.isCauseBytterException(btEx)) {
                logger.error(btEx.getMessage(), btEx);
                
                return AjaxObject.newError(btEx.getCause().getMessage()).toJson();
            }
            logger.error(btEx.getMessage(), btEx);
            return AjaxObject.newError(errorMessage).toJson();
        }
        catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return AjaxObject.newError(errorMessage).toJson();
        }
        
    }
    
    public static interface ExceptionHandler{
        public Object handle();
    }

}
