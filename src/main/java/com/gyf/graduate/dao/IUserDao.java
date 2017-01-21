package com.gyf.graduate.dao;

import com.gyf.graduate.domain.User;

/**
 * Created by GYF on 2017/1/7.
 */
public interface IUserDao extends IGeneralDao<User> {

    /**
     * 根据用户名/手机/邮箱与密码验证用户名和密码是否正确
     * @param accounts  用户名/手机/邮箱
     * @param password  密码
     * @return      若账号与密码匹配，则返回该用户对象，否则返回null
     */
    User login(String accounts, String password);
}
