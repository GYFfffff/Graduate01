package com.gyf.graduate.web.action;

import com.gyf.graduate.domain.Invitation;
import com.gyf.graduate.query.InvitationQueryObject;
import com.gyf.graduate.service.IinvitationService;
import com.opensymphony.xwork2.ActionContext;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * Created by GYF on 2017/1/14.
 */
@Controller
@Scope("prototype")
public class InvitationAction extends BaseAction {
    @Autowired
    private IinvitationService service;

    @Getter
    private InvitationQueryObject qo=new InvitationQueryObject();

    @Getter
    private Invitation invitation=new Invitation();

    @Override
    public String execute() throws Exception {
        ActionContext.getContext().put("pr",service.queryPage(qo));
        return "list";
    }

    public String getItemById(){
        if(invitation.getId()!=null){
            ActionContext.getContext().put("invitation",service.get(invitation.getId()));
        }
        return "invitation";
    }

    /**
     * 获取list页面JSON对象
     * @return
     * @throws IOException
     */
    public String getListWithJson() throws IOException {
        writerJSON(service.queryVO(qo).getDataList());
        return NONE;
    }
}
