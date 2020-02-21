package com.henu.test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class ValidAspect {

    public void validStart(JoinPoint joinPoint) {
        System.out.println("[ValidAspect普通" + joinPoint.getSignature().getName() + "]" + "开始执行了");
    }

    public void validEnd(JoinPoint joinPoint) {
        System.out.println("[ValidAspect普通" + joinPoint.getSignature().getName() + "]" + "执行结束了");
    }

    public void validReturn(JoinPoint joinPoint, Object result) {
        System.out.println("[ValidAspect普通" + joinPoint.getSignature().getName() + "]" + "执行结果为:" + result);
    }

    public void validException(JoinPoint joinPoint, Exception exception) {
        System.out.println("[ValidAspect普通" + joinPoint.getSignature().getName() + "]" + "执行异常了：" + exception);
    }

    public Object validAround(ProceedingJoinPoint pjp)throws Throwable{
        Object[] args=pjp.getArgs();
        Object proceed=null;
        try{

            System.out.println("[ValidAspect环绕通知" + pjp.getSignature().getName() + "]" + "开始执行了");
            proceed=pjp.proceed(args);
            System.out.println("[ValidAspect环绕通知" + pjp.getSignature().getName() + "]" + "执行结果为:" + proceed);
        }catch (Exception e){
            System.out.println("[ValidAspect环绕通知" + pjp.getSignature().getName() + "]" + "执行异常了：" + e);
        }finally {
            System.out.println("[ValidAspect环绕通知" + pjp.getSignature().getName() + "]" + "执行结束了");
        }
        return proceed;
    }
}
