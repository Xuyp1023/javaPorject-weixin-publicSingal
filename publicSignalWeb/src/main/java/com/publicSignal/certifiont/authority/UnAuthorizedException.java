/**   
 * @Title: UnAuthorizedException.java 
 * @Package com.publicSignal.certifiont.authority 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author xuyp
 * @date 2017年10月25日 下午2:10:42  
 */
package com.publicSignal.certifiont.authority;

/** 
 * @ClassName: UnAuthorizedException 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xuyp
 * @date 2017年10月25日 下午2:10:42 
 *  
 */
public class UnAuthorizedException extends Exception {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -4037427156484241784L;

    public UnAuthorizedException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UnAuthorizedException(String anMessage, Throwable anCause, boolean anEnableSuppression,
            boolean anWritableStackTrace) {
        super(anMessage, anCause, anEnableSuppression, anWritableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public UnAuthorizedException(String anMessage, Throwable anCause) {
        super(anMessage, anCause);
        // TODO Auto-generated constructor stub
    }

    public UnAuthorizedException(String anMessage) {
        super(anMessage);
        // TODO Auto-generated constructor stub
    }

    public UnAuthorizedException(Throwable anCause) {
        super(anCause);
        // TODO Auto-generated constructor stub
    }

}
