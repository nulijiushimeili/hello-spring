package spring.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * aop 面向切面编程
 * 1. 开启ASP支持
 * 2. 直接编写下面这个工具类,在什么方法上执行这个方法
 */
@Component
@Aspect
public class LogAspect {

    /**
     * 第一个 * 表示方法的任意返回值
     * 第二个 * 包下的所有类
     * 第三个 * 以add开头的所有方法
     * 括号里的 .. 表示任意参数
     */
    // 前置通知
    @Before("execution (* spring.dao.*.add*(..)) || execution (* spring.dao.*.update*(..))")
    public void methodStrat(JoinPoint point){
        // 通过连接点获取方法的名字
        MyLogger.getLogger().info(point.getSignature().getName());
        MyLogger.getLogger().info(" 这是一个前置通知");
    }

    // 后置通知
    @After("execution (* spring.dao.*.add*(..))")
    public void methodStop(){
        MyLogger.getLogger().info(" 这是一个后置通知");
    }

    // 环绕通知
    @Around("execution (* spring.dao.*.load*(..))")
    public void methodAround(ProceedingJoinPoint joinPoint){
        try {
            MyLogger.getLogger().info(" 执行了环绕通知");
            joinPoint.proceed();
            MyLogger.getLogger().info(" 执行了环绕通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    // 在方法执行返回值的时候
    @AfterReturning("execution (* spring.dao.*.load*(..))")
    public void methodReturn(){
        MyLogger.getLogger().info("当方法正常执行完成返回的时候,你会看到这个输出");
    }

    // 当方法遇到异常将要退出的时候将会执行
    @AfterThrowing("execution (* spring.dao.*.load*(..))")
    public void methodThrowing(){
        MyLogger.getLogger().info("方法遇到异常的时候,虚拟机退出之前会打印这句话");
    }
}

