package com.gyf.graduate.service;

import com.gyf.graduate.domain.Permission;
import com.gyf.graduate.page.PageResult;
import com.gyf.graduate.query.QueryObject;

import java.util.List;

/**
 * Created by GYF on 2017/1/8.
 */
public interface IPermissionService {
    /**
     * 保存传入的实体对象
     * @param entity    被保存对象
     */
    void save(Permission entity);

    /**
     * 更新传入的实体对象
     * @param entity    更新的对象
     */
    void update(Permission entity);

    /**
     * 删除传入的实体对象
     * @param entity    被删除对象
     */
    void delete(Permission entity);

    /**
     * 根据传入ID查询记录
     * @param id    被查询对象的ID
     * @return      被查询对象
     */
    Permission get(Long id);

    /**
     * 查询所有记录
     * @return      所有对象的集合
     */
    List<Permission> getAll();

    /**
     * 根据查询条件进行分页查询
     * @param qo    查询条件对象
     * @return  符合查询条件的分页对象
     */
    PageResult<Permission> queryPage(QueryObject qo);

    /**
     * 扫描并加载注解
     */
    void loadPermission();
}
