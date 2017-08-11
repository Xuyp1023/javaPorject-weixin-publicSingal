package com.publicSignal.util;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AjaxObject implements Serializable{
    
 /**
     * 
     */
    private static final long serialVersionUID = 451868353334352827L;
    // 状态码
    private final static int STATUS_CODE_SUCCESS = 200;
    private final static int STATUS_CODE_FAILURE = 300;
    private ObjectMapper mapper = new CustomMapper();
    
    private int statusCode = 0;

    private String message = "";
    
    private Object data;

    public AjaxObject(int anStatusCode, String anMessage, Object anData) {
        super();
        this.statusCode = anStatusCode;
        this.message = anMessage;
        this.data = anData;
    }

    public AjaxObject() {
        super();
    }

    public AjaxObject(int anStatusCode) {
        super();
        this.statusCode = anStatusCode;
    }

    public AjaxObject(int anStatusCode, String anMessage) {
        super();
        this.statusCode = anStatusCode;
        this.message = anMessage;
    }

    public AjaxObject(Object anData) {
        super();
        this.data = anData;
    }
    
    public static AjaxObject newOk(Object anData){
        
        return new AjaxObject(STATUS_CODE_SUCCESS, "ok", anData);
        
    }
    
    public static AjaxObject newError(String message){
        
        return new AjaxObject(STATUS_CODE_FAILURE, message, null);
        
    }
    
    public String toJson() {
        
        
        try {
            System.out.println(this);
            return mapper.writeValueAsString(this);
        }
        catch (JsonProcessingException e) {
            
            e.printStackTrace();
        }
        
        return "";
    }

    @Override
    public String toString() {
        return "AjaxObject [mapper=" + this.mapper + ", statusCode=" + this.statusCode + ", message=" + this.message + ", data=" + this.data + "]";
    }
    
    

}
