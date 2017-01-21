package com.gyf.graduate.dao.impl;

import com.gyf.graduate.dao.IinvitationDao;
import com.gyf.graduate.domain.Invitation;
import com.gyf.graduate.domain.view.InvitationVO;
import com.gyf.graduate.page.PageResult;
import com.gyf.graduate.query.QueryObject;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by GYF on 2017/1/14.
 */
@Repository
public class InvitationDaoImpl extends GeneralDaoImpl<Invitation> implements IinvitationDao{
    public PageResult<InvitationVO> queryVO(QueryObject qo) {
        //获取该符合该条件的的记录数
        int count = getCount(qo);
        //若没有符合条件的记录，则返回空查询结果集对象
        if(count==0){
            return PageResult.getEmpty(qo.getPageSize());
        }

        Query query = super.getSessionFactory().getCurrentSession().createQuery("SELECT NEW InvitationVO(obj.id,obj.content,obj.createDate,obj.user.id,obj.user.userName) FROM  Invitation obj " + qo.getQuery());
        super.setParams(query,qo);
        query.setFirstResult(qo.getFirstIndex());
        query.setMaxResults(qo.getPageSize());
        return new PageResult<InvitationVO>(query.list(),qo.getCurrentPage(),qo.getPageSize(),count);
    }
}
