package com.gyf.graduate.service.impl;

import com.gyf.graduate.dao.ICommentDao;
import com.gyf.graduate.domain.Comment;
import com.gyf.graduate.domain.User;
import com.gyf.graduate.page.PageResult;
import com.gyf.graduate.query.QueryObject;
import com.gyf.graduate.service.ICommentService;
import com.gyf.graduate.util.ConstantUtils;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by GYF on 2017/1/14.
 */
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private ICommentDao dao;

    public void save(Comment entity) {
        //设置发表时间
        entity.setCreateTime(new Date());
        //设置发表评论的用户
        entity.setUser((User) ActionContext.getContext().getSession().get(ConstantUtils.USER_IN_SESSION));
        dao.save(entity);
    }

    public void delete(Comment entity) {
        dao.delete(entity);
    }

    public Comment get(Long id) {
        return dao.get(id);
    }

    public List<Comment> getAll() {
        return dao.getAll();
    }

    public PageResult<Comment> queryPage(QueryObject qo) {
        return dao.queryPage(qo);
    }
}
