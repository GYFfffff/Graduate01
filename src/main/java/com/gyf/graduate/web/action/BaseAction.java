package com.gyf.graduate.web.action;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by GYF on 2017/1/8.
 */
public abstract class BaseAction extends ActionSupport {
    public void writerJSON(Object obj) throws IOException {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().print(JSON.toJSONString(obj));
    }
}
