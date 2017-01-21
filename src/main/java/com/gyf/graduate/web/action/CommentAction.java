package com.gyf.graduate.web.action;

import com.gyf.graduate.domain.Comment;
import com.gyf.graduate.service.ICommentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by GYF on 2017/1/17.
 */
@Controller
@Scope("prototype")
public class CommentAction extends BaseAction {
    @Autowired
    private ICommentService service;

    @Getter
    private Comment comment=new Comment();

    private String save(){
        service.save(comment);
        return NONE;
    }
}
