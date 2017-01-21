package com.gyf.graduate.domain.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * Created by GYF on 2017/1/16.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvitationVO {
    private Long id;
    private String content;
    private Date createDate;

    private Long userId;
    private String userName;
}
