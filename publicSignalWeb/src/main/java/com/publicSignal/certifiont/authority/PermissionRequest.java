/**   
 * @Title: PermissionRequest.java 
 * @Package com.publicSignal.certifiont.authority 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author xuyp
 * @date 2017年10月25日 下午1:49:24  
 */
package com.publicSignal.certifiont.authority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @ClassName: PermissionRequest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xuyp
 * @date 2017年10月25日 下午1:49:24 
 *  
 */

@Target(value = { ElementType.METHOD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface PermissionRequest {

    String permissionRrequestCode() default "";

}
