package com.gyf.graduate.dao.impl;

import com.gyf.graduate.dao.IGeneralDao;
import com.gyf.graduate.page.PageResult;
import com.gyf.graduate.query.QueryObject;
import lombok.Getter;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by GYF on 2017/1/7.
 */

abstract class GeneralDaoImpl<T> implements IGeneralDao<T> {
    @Autowired
    @Getter
    private SessionFactory sessionFactory;
    private Class<T> clzz;     //泛型的真实类型

    /**
     * 子类初始化时调用，用于获取实体对象的Class
     */
    GeneralDaoImpl(){
        //通过子类获取带泛型的父类的字节码文件
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获取泛型的真实类型
        clzz = (Class) genericSuperclass.getActualTypeArguments()[0];
    }

    public void save(T entity) {
        sessionFactory.getCurrentSession().save(entity);
    }


    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }


    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }


    public T get(Long id) {
        return (T) sessionFactory.getCurrentSession().get(clzz,id);
    }


    public List<T> getAll() {
        return sessionFactory.getCurrentSession().createQuery("SELECT obj FROM "+clzz.getSimpleName()+" obj ").list();
    }

    public PageResult<T> queryPage(QueryObject qo) {
        //获取该符合该条件的的记录数
        int count = getCount(qo);
        //若没有符合条件的记录，则返回空查询结果集对象
        if(count==0){
            return PageResult.getEmpty(qo.getPageSize());
        }

        Query query = sessionFactory.getCurrentSession().createQuery("SELECT obj FROM " + clzz.getSimpleName() + " obj " + qo.getQuery());
        setParams(query,qo);
        query.setFirstResult(qo.getFirstIndex());
        query.setMaxResults(qo.getPageSize());
        return new PageResult<T>(query.list(),qo.getCurrentPage(),qo.getPageSize(),count);
    }

    public int getCount(QueryObject qo) {
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT COUNT(obj) FROM " + clzz.getSimpleName() + " obj "+qo.getQuery());
        setParams(query,qo);
        return ((Long)query.uniqueResult()).intValue();
    }

    /**
     * 给查询条件设置查询参数
     * @param query 查询对象
     * @param qo    条件对象
     */
    protected void setParams(Query query,QueryObject qo){
        for(int i=0;i<qo.getParams().size();i++){
            query.setParameter(i,qo.getParams().get(i));
            System.out.println();
        }
    }
}
