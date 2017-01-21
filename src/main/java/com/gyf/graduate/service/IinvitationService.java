package com.gyf.graduate.service;

import com.gyf.graduate.domain.Invitation;
import com.gyf.graduate.domain.view.InvitationVO;
import com.gyf.graduate.page.PageResult;
import com.gyf.graduate.query.QueryObject;

import java.util.List;

/**
 * Created by GYF on 2017/1/14.
 */
public interface IinvitationService {
    /**
     * 保存传入的实体对象
     * @param entity    被保存对象
     */
    void save(Invitation entity);


    /**
     * 删除传入的实体对象
     * @param entity    被删除对象
     */
    void delete(Invitation entity);

    /**
     * 根据传入ID查询记录
     * @param id    被查询对象的ID
     * @return      被查询对象
     */
    Invitation get(Long id);

    /**
     * 查询所有记录
     * @return      所有对象的集合
     */
    List<Invitation> getAll();

    /**
     * 根据查询条件进行分页查询
     * @param qo    查询条件对象
     * @return  符合查询条件的分页对象
     */
    PageResult<Invitation> queryPage(QueryObject qo);

    PageResult<InvitationVO> queryVO(QueryObject qo);
}
