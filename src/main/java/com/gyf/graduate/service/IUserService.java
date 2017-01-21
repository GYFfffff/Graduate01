package com.gyf.graduate.service;

import com.gyf.graduate.domain.User;
import com.gyf.graduate.page.PageResult;
import com.gyf.graduate.query.QueryObject;

import java.util.List;

/**
 * Created by GYF on 2017/1/7.
 */
public interface IUserService {
    /**
     * 保存传入的实体对象
     * @param entity    被保存对象
     */
    void save(User entity);

    /**
     * 更新传入的实体对象
     * @param entity    更新的对象
     */
    void update(User entity);

    /**
     * 删除传入的实体对象
     * @param entity    被删除对象
     */
    void delete(User entity);

    /**
     * 根据传入ID查询记录
     * @param id    被查询对象的ID
     * @return      被查询对象
     */
    User get(Long id);

    /**
     * 查询所有记录
     * @return      所有对象的集合
     */
    List<User> getAll();

    /**
     * 根据查询条件进行分页查询
     * @param qo    查询条件对象
     * @return  符合查询条件的分页对象
     */
    PageResult<User> queryPage(QueryObject qo);

    /**
     * 登陆
     * @param accounts 账号，可为用户名/手机号/邮箱
     * @param password  密码
     */
    void login(String accounts,String password);

    /**
     * 注册
     * @param accounts  账号，可为用户名/手机号/邮箱
     * @param password  密码
     */
    void register(String accounts,String password);

    /**
     * 检查该账号是否已存在
     * @param accounts
     */
    void checkAccountsExist(String accounts);
}
