package com.gyf.graduate.domain;

/**
 * Created by GYF on 2017/1/7.
 */

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 存储用户信息
 * 用户可根据用户名，邮箱，手机号其中之一作为账号登陆
 */
@Getter@Setter
public class User extends BaseDomain {

    private String userName;    //用户名，唯一
    private String email;       //邮箱，唯一
    private String phoneNumber;     //手机号，唯一

    private String Password;    //密码
    private Boolean isAdmin=false;    //是否为超级管理员,默认为False

    private List<Role> roles=new ArrayList<Role>();   //该对象拥有的角色
    private List<Invitation> appearInvitations;     //该用户发表的主题，一对多，放弃维护
    private List<Invitation> attentionInvitations;      //该用户关注的主题，双向多对多，放弃维护
    private List<Comment> comments;     //该用户发表的评论，双向一对多，放弃维护

}
