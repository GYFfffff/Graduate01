package com.gyf.graduate.page;

/**
 * Created by GYF on 2017/1/7.
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

/**
 * 封装结果集及分页相关信息
 */
@Getter@Setter
@ToString
public class PageResult<T> {
    private List<T> dataList;   //该分页的查询结果集合
    private Integer currentPage;    //当前页
    private Integer pageSize;   //页大小
    private Integer totalCount;     //总记录数

    private Integer totalPage;  //总页数
    private Integer prevPage;    //上一页
    private Integer nextPage;   //下一页

    /**
     * 返回一个没有查询结果的对象
     * @param pageSize  页面大小
     * @return  空对象
     */
    public static PageResult getEmpty(Integer pageSize){
        return new PageResult(Collections.EMPTY_LIST, 1, pageSize, 0);
    }

    /**
     * 初始化，因为总页数，上一页，下一页均能通过计算打到，所以不需要传入
     * @param dataList  结果集合
     * @param currentPage   当前页
     * @param pageSize  页面大小
     * @param totalCount    总记录数
     */
    public PageResult(List<T> dataList, Integer currentPage, Integer pageSize, Integer totalCount) {
        this.dataList = dataList;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;

        this.totalPage=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        this.prevPage=currentPage>1?currentPage-1:1;
        this.nextPage=currentPage<totalPage?currentPage+1:currentPage;
    }
}
