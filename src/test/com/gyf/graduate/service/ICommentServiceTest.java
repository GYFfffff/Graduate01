package com.gyf.graduate.service;

import com.gyf.graduate.domain.Comment;
import com.gyf.graduate.domain.Invitation;
import com.gyf.graduate.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by GYF on 2017/1/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ICommentServiceTest {
    @Autowired
    private ICommentService service;
    @Test
    public void save() throws Exception {
        Comment comment=new Comment();
        comment.setContext("测试测试测试");
        Invitation invi=new Invitation();
        invi.setId(101L);
        comment.setInvitation(invi);
        User user=new User();
        user.setId(1L);
        comment.setUser(user);
        //service.save(comment);
    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void queryPage() throws Exception {

    }

}