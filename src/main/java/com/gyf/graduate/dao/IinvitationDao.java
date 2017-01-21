package com.gyf.graduate.dao;


import com.gyf.graduate.domain.Invitation;
import com.gyf.graduate.domain.view.InvitationVO;
import com.gyf.graduate.page.PageResult;
import com.gyf.graduate.query.QueryObject;

/**
 * Created by GYF on 2017/1/14.
 */
public interface IinvitationDao extends IGeneralDao<Invitation> {
    PageResult<InvitationVO> queryVO(QueryObject qo);
}
