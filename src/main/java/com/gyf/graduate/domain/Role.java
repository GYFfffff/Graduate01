package com.gyf.graduate.domain;

/**
 * Created by GYF on 2017/1/8.
 */

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色对象
 */
@Getter@Setter
public class Role extends BaseDomain {
    private String name;    //角色名称
    private String sn;      //角色编码
    private List<Permission> permissionList=new ArrayList<Permission>();    //权限集合
}
