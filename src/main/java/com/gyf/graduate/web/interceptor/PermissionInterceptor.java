package com.gyf.graduate.web.interceptor;

import com.gyf.graduate.anno.RequestPermission;
import com.gyf.graduate.domain.User;
import com.gyf.graduate.util.ConstantUtils;
import com.gyf.graduate.util.PermissionUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by GYF on 2017/1/12.
 */

/**
 * 进行权限验证
 */
public class PermissionInterceptor extends AbstractInterceptor {

    public String intercept(ActionInvocation invocation) throws Exception {
        //获取当前用户对象
        User u = (User) invocation.getInvocationContext().getSession().get(ConstantUtils.USER_IN_SESSION);
        //若该用户为超级管理员，则直接放行
        if(u.getIsAdmin()){
            return invocation.invoke();
        }
        //若访问的资源没有进行权限控制，则放行
        String methodName = invocation.getProxy().getMethod();
        Method method = invocation.getAction().getClass().getMethod(methodName);
        RequestPermission annotation = method.getAnnotation(RequestPermission.class);
        if(annotation==null){
            return invocation.invoke();
        }
        //否则验证该用户是否有访问权限
        List<String> expressionList = (List<String>) invocation.getInvocationContext().getSession().get(ConstantUtils.EXPRESSIONS_IN_SESSION);
        String expression = PermissionUtils.getExpressionByMethod(method);
        if(expressionList.contains(expression)){
            return invocation.invoke();
        }
        //没有访问权限，返回错误页面
        return "error";
    }
}
