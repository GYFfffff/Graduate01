package com.gyf.graduate.domain;

/**
 * Created by GYF on 2017/1/12.
 */

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 *评论对象
 */
@Getter
@Setter
public class Comment extends BaseDomain {
    private String context;     //评论内容
    private Date createTime;      //发表时间

    private Invitation invitation;  //该评论的主题，双向多对一
    private User user;      //发表评论用户
    private Comment reComment;  //引用的评论（回复）

    @Override
    public String toString() {
        return "Comment{" +
                "context='" + context + '\'' +
                ", createTime=" + createTime +
                ", invitation=" + invitation.getId() +
                ", user=" + user.getId() +
                ", reComment=" + reComment.getId() +
                '}';
    }
}
