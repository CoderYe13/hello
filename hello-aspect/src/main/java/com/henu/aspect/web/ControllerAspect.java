package com.henu.aspect.web;

import org.aspectj.lang.JoinPoint;

public class ControllerAspect {
//    public ControllerAspect() {
//        System.out.println("ControllerAspect被创建了");
//    }
    public void controllerStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getDeclaringType()+"我被创建了....");
    }
    public void controllerEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName());
    }
    public void controllerReturning(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+" : "+result);
    }
    public void controllerException(JoinPoint joinPoint,Exception exception){
        System.out.println(joinPoint.getSignature().getName()+"出现异常了，异常信息为："+exception);
    }


}
