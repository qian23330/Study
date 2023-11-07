package com.itheima.d5_proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static UserService createProxy(UserService userService){
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(),
                new Class[]{UserService.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        if(method.getName().equals("login") || method.getName().equals("deleteUsers")||
                               method.getName().equals("selectUsers")){
                            long startTime = System.currentTimeMillis();

                            Object rs = method.invoke(userService, args);

                            long endTime = System.currentTimeMillis();
                            System.out.println(method.getName() + "方法执行耗时：" + (endTime - startTime)/ 1000.0 + "s");
                            return rs;
                        }else {
                            Object rs = method.invoke(userService, args);
                            return rs;
                        }
                    }
                });
        return userServiceProxy;
    }
}
