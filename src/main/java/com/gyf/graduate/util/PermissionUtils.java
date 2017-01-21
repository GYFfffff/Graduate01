package com.gyf.graduate.util;

import java.lang.reflect.Method;

/**
 * Created by GYF on 2017/1/8.
 */


public class PermissionUtils {
    private PermissionUtils(){}

    /**
     * 通过传入方法对象获取该对象的权限表达式
     * @param method    方法对象
     * @return  权限表达式
     *
     */
    public static String getExpressionByMethod(Method method){
        //获取该方法所在的类的全限定名
        String className = method.getDeclaringClass().getName();
        return className+":"+method.getName();

    }


}
