package com.gyf.graduate.dao.impl;

import com.gyf.graduate.dao.IUserDao;
import com.gyf.graduate.domain.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by GYF on 2017/1/7.
 */
@Repository
public class UserDaoImpl extends GeneralDaoImpl<User> implements IUserDao {
    /**
     * 根据用户名/手机/邮箱与密码验证用户名和密码是否正确
     *
     * @param accounts 用户名/手机/邮箱
     * @param password 密码
     * @return 若账号与密码匹配，则返回该用户对象，否则返回null
     */
    public User login(String accounts, String password) {
        Query query = super.getSessionFactory().getCurrentSession().createQuery("SELECT u FROM User u WHERE (u.userName=? OR u.email=? OR u.phoneNumber=?) AND u.password=? ");
        query.setString(0,accounts).setString(1,accounts).setString(2,accounts).setString(3,password);
        return (User) query.uniqueResult();
    }
}
