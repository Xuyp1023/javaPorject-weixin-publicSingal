package com.publicSignal.exception;


public class PublicSignalException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 603851043321352727L;
    
    private String message;
    
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String anMessage) {
        this.message = anMessage;
    }

    public PublicSignalException(String anMessage) {
        super();
        this.message = anMessage;
    }

    public PublicSignalException() {
        super();
        
    }

    public PublicSignalException(String anMessage, Throwable anCause, boolean anEnableSuppression, boolean anWritableStackTrace) {
        super(anMessage, anCause, anEnableSuppression, anWritableStackTrace);
        this.message=anMessage;
    }

    public PublicSignalException(String anMessage, Throwable anCause) {
        super(anMessage, anCause);
        this.message=anMessage;
    }

    public PublicSignalException(Throwable anCause) {
        super(anCause);
        
    }
    
    public static boolean isCauseBytterException(Exception btEx){
        if(btEx.getCause()!=null && btEx.getCause() instanceof PublicSignalException){
            return true;
        }
        return false;
    }

}
