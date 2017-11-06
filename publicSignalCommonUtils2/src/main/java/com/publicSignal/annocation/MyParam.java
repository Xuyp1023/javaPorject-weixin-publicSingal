/**   
 * @Title: MyParam.java 
 * @Package com.publicSignal.annocation 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author xuyp
 * @date 2017年11月6日 上午10:19:51  
 */
package com.publicSignal.annocation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 
 * @ClassName: MyParam 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xuyp
 * @date 2017年11月6日 上午10:19:51 
 *  
 */

@Target(value = { ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyParam {

}
