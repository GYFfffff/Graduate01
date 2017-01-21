package com.gyf.graduate.web.interceptor;

import com.gyf.graduate.domain.User;
import com.gyf.graduate.util.ConstantUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by GYF on 2017/1/8.
 */

/**
 * 进行登陆验证
 */
public class LoginInterceptor extends AbstractInterceptor {

    public String intercept(ActionInvocation invocation) throws Exception {
        User u = (User) invocation.getInvocationContext().getSession().get(ConstantUtils.USER_IN_SESSION);
        //若用户没有登陆，则返回登陆页面
        if(u==null){
            return "login";
        }
        return invocation.invoke();
    }
}
