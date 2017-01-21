package com.gyf.graduate.domain;

/**
 * Created by GYF on 2017/1/12.
 */

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 主题对象
 */
@Getter
@Setter
public class Invitation extends BaseDomain {
    private String content; //内容
    private Date createDate;    //发表时间
    private Type type;    //分类，1-IOS,2-安卓,3-WINDOW,4-LINUX

    private User user;      //发表用户

    private List<User> attentionUsers=new ArrayList<User>();  //关注该主题的用户，双向多对多
    private List<Comment> comments=new ArrayList<Comment>();     //该主题的评论，双向一对多，放弃维护

}
