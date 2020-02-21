package com.henu.test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogUtil {
    @Pointcut("execution(public * com.henu.test.service.Calculator.*(..))")
    public void logTest() {
    };

    @Before(value = "logTest()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println("[普通" + joinPoint.getSignature().getName() + "]" + "开始执行了");
    }

    @After(value = "logTest()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("[普通" + joinPoint.getSignature().getName() + "]" + "执行结束了");
    }

    @AfterReturning(value = "logTest()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("[普通" + joinPoint.getSignature().getName() + "]" + "执行结果为:" + result);
    }

    @AfterThrowing(value = "logTest()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println("[普通" + joinPoint.getSignature().getName() + "]" + "执行异常了：" + exception);
    }

    @Around(value = "logTest()")
    public Object logAround(ProceedingJoinPoint pjp)throws Throwable{
        Object[] args=pjp.getArgs();
        Object proceed=null;
        try{

            System.out.println("[环绕通知" + pjp.getSignature().getName() + "]" + "开始执行了");
            proceed=pjp.proceed(args);
            System.out.println("[环绕通知" + pjp.getSignature().getName() + "]" + "执行结果为:" + proceed);
        }catch (Exception e){
            System.out.println("[环绕通知" + pjp.getSignature().getName() + "]" + "执行异常了：" + e);
        }finally {
            System.out.println("[环绕通知" + pjp.getSignature().getName() + "]" + "执行结束了");
        }
        return proceed;
    }
}
