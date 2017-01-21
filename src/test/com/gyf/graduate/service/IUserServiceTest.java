package com.gyf.graduate.service;

import com.gyf.graduate.domain.Invitation;
import com.gyf.graduate.query.InvitationQueryObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by GYF on 2017/1/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IUserServiceTest {
    @Autowired
    IinvitationService service;
    @Autowired
    IUserService userService;
    @Test
    public void save() throws Exception {
        for (int i = 0; i < 100; i++) {
            Invitation invitation=new Invitation();
            invitation.setContent("测试内容，test,测试内容，test,测试内容，test,测试内容，test,测试内容，test,测试内容，test,测试内容，test,测试内容，test测试内容，test,测试内容，test测试内容，test,测试内容，test");
            invitation.setCreateDate(new Date());

            invitation.setUser(userService.get(1L));
            service.save(invitation);
        }
    }

    @Test
    public void queryPage() throws Exception {
        InvitationQueryObject qo=new InvitationQueryObject();
        System.out.println(service.queryPage(qo));
    }

    @Test
    public void login() throws Exception {
    }

    @Test
    public void register() throws Exception {
        System.out.println(service.queryVO(new InvitationQueryObject()));
    }

}