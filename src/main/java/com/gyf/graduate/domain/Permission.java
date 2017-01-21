package com.gyf.graduate.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by GYF on 2017/1/8.
 */

/**
 * 权限对象
 */
@Getter@Setter
public class Permission extends BaseDomain {
    private String name;    //权限名
    private String expression;    //权限表达式，形式为  类的全限定名:方法名

    @Override
    public String toString() {
        return "Permission{" +
                "name='" + name + '\'' +
                ", expression='" + expression + '\'' +
                '}';
    }
}
