package com.gyf.graduate.dao;

/**
 * Created by GYF on 2017/1/7.
 */

import com.gyf.graduate.page.PageResult;
import com.gyf.graduate.query.QueryObject;

import java.util.List;

/**
 * 通用接口
 */
public interface IGeneralDao<T> {
    /**
     * 保存传入的实体对象
     * @param entity    被保存对象
     */
    void save(T entity);

    /**
     * 更新传入的实体对象
     * @param entity    更新的对象
     */
    void update(T entity);

    /**
     * 删除传入的实体对象
     * @param entity    被删除对象
     */
    void delete(T entity);

    /**
     * 根据传入ID查询记录
     * @param id    被查询对象的ID
     * @return      被查询对象
     */
    T get(Long id);

    /**
     * 查询所有记录
     * @return      所有对象的集合
     */
    List<T> getAll();

    /**
     * 根据查询条件进行分页查询
     * @param qo    查询条件对象
     * @return  符合查询条件的分页对象
     */
    PageResult<T> queryPage(QueryObject qo);

    /**
     * 获取符合查询条件的记录数
     * @param qo    查询条件对象
     * @return  总记录数
     */
    int getCount(QueryObject qo);
}
