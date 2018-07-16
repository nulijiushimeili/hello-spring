package spring.proxy;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.testng.annotations.Test;
import spring.annotation.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * 1. 创建一个类实现InvocationHandler
 * 2. 创建代理对象
 * 3. 创建一个方法获取代理对象
 */
// 1. 创建一个实现InvocationHandler接口的类
    @Service("logDynamicProxy")
public class LogProxy implements InvocationHandler {
    private static Logger logger = LogManager.getLogger(Test.class.getName());

    // 2. 创建代理对象
    private Object target;

    // 3. 返回代理对象,参数是要代理的对象
    public static Object getInstance(Object o){
        // 4. 将要代理的对象,赋值给代理对象
        LogProxy logProxy = new LogProxy();
        logProxy.target = o;
        // 5. 开始代理
        // 第一个参数是要代理的对象,要代理对象的所有接口,实现了InvocationHandler接口的类的实例
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),logProxy);

    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        if("add".equals(method.getName())){
//            Log.log("添加了插入数据的操作");
//        }

        logger.info("正在执行invoke()----");
        if(method.isAnnotationPresent(Log.class)){
            Log log = method.getAnnotation(Log.class);
            spring.log.Log.log(log.value());
        }
        return (Object) method.invoke(target,args);
    }
}
