package com.gyf.graduate.service.impl;

import com.gyf.graduate.dao.IinvitationDao;
import com.gyf.graduate.domain.Invitation;
import com.gyf.graduate.domain.view.InvitationVO;
import com.gyf.graduate.page.PageResult;
import com.gyf.graduate.query.QueryObject;
import com.gyf.graduate.service.IinvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GYF on 2017/1/14.
 */
@Service
public class InvitaionServiceImpl implements IinvitationService {

    @Autowired
    private IinvitationDao dao;

    /**
     * 保存传入的实体对象
     *
     * @param entity 被保存对象
     */
    public void save(Invitation entity) {
        dao.save(entity);
    }

    /**
     * 删除传入的实体对象
     *
     * @param entity 被删除对象
     */
    public void delete(Invitation entity) {
        dao.delete(entity);
    }

    /**
     * 根据传入ID查询记录
     *
     * @param id 被查询对象的ID
     * @return 被查询对象
     */
    public Invitation get(Long id) {
        return dao.get(id);
    }

    /**
     * 查询所有记录
     *
     * @return 所有对象的集合
     */
    public List<Invitation> getAll() {
        return dao.getAll();
    }

    /**
     * 根据查询条件进行分页查询
     *
     * @param qo 查询条件对象
     * @return 符合查询条件的分页对象
     */
    public PageResult<Invitation> queryPage(QueryObject qo) {
        return dao.queryPage(qo);
    }

    public PageResult<InvitationVO> queryVO(QueryObject qo) {
        return dao.queryVO(qo);
    }
}
