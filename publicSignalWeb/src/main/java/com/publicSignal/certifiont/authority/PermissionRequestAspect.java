/**   
 * @Title: PermissionRequestAspect.java 
 * @Package com.publicSignal.certifiont.authority 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author xuyp
 * @date 2017年10月25日 下午1:54:06  
 */
package com.publicSignal.certifiont.authority;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/** 
 * @ClassName: PermissionRequestAspect 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xuyp
 * @date 2017年10月25日 下午1:54:06 
 *  
 */

@Aspect
@Component
public class PermissionRequestAspect {

    @Pointcut(value = "@annotation (com.publicSignal.certifiont.authority.PermissionRequest)")
    public void permissionAspect() {

    }

    @Before("permissionAspect()")
    public void permissionCOdeCheck(JoinPoint joinPoint) throws Exception {

        String permissionCode = resolveAnnotation(joinPoint);
        if (!"userAdd".equals(permissionCode)) {
            throw new UnAuthorizedException("不是新增权限");
        }

    }

    private String resolveAnnotation(JoinPoint joinPoint) throws Exception {

        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String permissionCode = "";

        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class<?>[] clazz = method.getParameterTypes();
                if (clazz.length == arguments.length) {
                    permissionCode = method.getAnnotation(PermissionRequest.class).permissionRrequestCode();
                    break;
                }
            }
        }

        return permissionCode;

    }
}
