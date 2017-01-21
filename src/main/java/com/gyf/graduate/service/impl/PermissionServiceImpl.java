package com.gyf.graduate.service.impl;

import com.gyf.graduate.anno.RequestPermission;
import com.gyf.graduate.dao.IPermissionDao;
import com.gyf.graduate.domain.Permission;
import com.gyf.graduate.page.PageResult;
import com.gyf.graduate.query.QueryObject;
import com.gyf.graduate.service.IPermissionService;
import com.gyf.graduate.util.PermissionUtils;
import com.gyf.graduate.web.action.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by GYF on 2017/1/8.
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao dao;
    @Autowired
    private ApplicationContext applicationContext;

    public void save(Permission entity) {
        dao.save(entity);
    }

    public void update(Permission entity) {
        dao.update(entity);
    }


    public void delete(Permission entity) {
        dao.delete(entity);
    }


    public Permission get(Long id) {
        return dao.get(id);
    }


    public List<Permission> getAll() {
        return dao.getAll();
    }


    public PageResult<Permission> queryPage(QueryObject qo) {
        return dao.queryPage(qo);
    }


    public void loadPermission() {
        //获取当前数据库中已有注解记录
        List<Permission> permissions = dao.getAll();
        List<String> expressions = new ArrayList<String>();    //保存当前已有的注解表达式
        for (Permission permission : permissions) {
            expressions.add(permission.getExpression());
        }

        //获取当前Spring容器中所有的BaseAction类
        Map<String, BaseAction> actions = applicationContext.getBeansOfType(BaseAction.class);

        for (BaseAction action : actions.values()) {
            Method[] methods = action.getClass().getMethods();
            for (Method method : methods) {
                //获取带有权限控制注解的方法
                RequestPermission rpAnno = method.getClass().getAnnotation(RequestPermission.class);
                if (rpAnno != null) {
                    //获取权限表达式
                    String expression = PermissionUtils.getExpressionByMethod(method);
                    //若该权限表达式不在数据库中，则新添
                    if (!expressions.contains(expression)) {
                        Permission newPermission = new Permission();
                        newPermission.setName(rpAnno.value());
                        newPermission.setExpression(expression);
                        dao.save(newPermission);
                    }
                }
            }
        }

    }


}
