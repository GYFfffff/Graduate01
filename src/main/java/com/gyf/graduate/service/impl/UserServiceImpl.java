package com.gyf.graduate.service.impl;

import com.gyf.graduate.dao.IUserDao;
import com.gyf.graduate.domain.Permission;
import com.gyf.graduate.domain.Role;
import com.gyf.graduate.domain.User;
import com.gyf.graduate.page.PageResult;
import com.gyf.graduate.query.QueryObject;
import com.gyf.graduate.service.IUserService;
import com.gyf.graduate.util.ConstantUtils;
import com.gyf.graduate.util.MD5;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GYF on 2017/1/7.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao dao;

    /**
     * 保存传入的实体对象
     *
     * @param entity 被保存对象
     */
    public void save(User entity) {
        dao.save(entity);
    }

    /**
     * 更新传入的实体对象
     *
     * @param entity 更新的对象
     */
    public void update(User entity) {
        dao.update(entity);
    }

    /**
     * 删除传入的实体对象
     *
     * @param entity 被删除对象
     */
    public void delete(User entity) {
        dao.delete(entity);
    }

    /**
     * 根据传入ID查询记录
     *
     * @param id 被查询对象的ID
     * @return 被查询对象
     */
    public User get(Long id) {
        return dao.get(id);
    }

    /**
     * 查询所有记录
     *
     * @return 所有对象的集合
     */
    public List<User> getAll() {
        return dao.getAll();
    }

    /**
     * 根据查询条件进行分页查询
     *
     * @param qo 查询条件对象
     * @return 符合查询条件的分页对象
     */
    public PageResult<User> queryPage(QueryObject qo) {
        return dao.queryPage(qo);
    }

    public void login(String accounts, String password) {
        //加密
        password= MD5.encode(password);
        User u = dao.login(accounts, password);
        if(u!=null){
            //账户密码正确
            //共享登陆用户信息
             ActionContext.getContext().getSession().put(ConstantUtils.USER_IN_SESSION,u);
            //共享登陆用户权限表达式
            List<Role> roles = u.getRoles();
            List<String> expressionList=new ArrayList<String>();
            for (Role role : roles) {
                List<Permission> permissionList = role.getPermissionList();
                for (Permission permission : permissionList) {
                    expressionList.add(permission.getExpression());
                }
            }
            ActionContext.getContext().getSession().put(ConstantUtils.EXPRESSIONS_IN_SESSION,expressionList);
        }else {
            throw new RuntimeException("账号或密码错误！");
        }

    }

    /**
     * 注册
     *
     * @param accounts 账号，可为用户名/手机号/邮箱
     * @param password 密码
     */
    public void register(String accounts, String password) {
        User user=new User();

        user.setPassword(MD5.encode(password));
        //判断账号类型
        if(accounts.contains("@")){
            user.setEmail(accounts);
        }else if(accounts.length()==11){
            user.setPhoneNumber(accounts);
        }else {
            user.setUserName(accounts);
        }
        dao.save(user);

    }

    /**
     * 检查该账号是否已存在
     *
     * @param accounts
     */
    public void checkAccountsExist(String accounts) {

    }

}
