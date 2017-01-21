package com.gyf.graduate.service;

import com.gyf.graduate.domain.User;
import com.gyf.graduate.query.InvitationQueryObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by GYF on 2017/1/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {
    @Autowired
    IUserService service;
    @Test
    public void save() throws Exception {
        User u=new User();
        u.setUserName("admin");
        u.setPassword("1234");
        service.save(u);
    }
    @Test
    public void test01(){
        System.out.println(service.queryPage(new InvitationQueryObject()));
    }

}