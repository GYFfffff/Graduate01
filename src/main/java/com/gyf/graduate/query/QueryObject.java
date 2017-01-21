package com.gyf.graduate.query;

/**
 * Created by GYF on 2017/1/7.
 */

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据条件进行高级查询的时候，将查询条件封装到该对象中
 * 并可根据该对象获取查询条件以及查询参数
 */
public abstract class QueryObject {
    private final Integer DEFAULT_CURRENTPAGE=1;    //默认当前页
    private final Integer DEFAULT_PAGESIZE=10;      //默认页大小

    private List<String> conditions=new ArrayList<String>();    //查询条件的集合
    @Getter
    private List<Object> params=new ArrayList<Object>();    //查询条件对应参数的集合

    @Getter@Setter
    private Integer currentPage=DEFAULT_CURRENTPAGE;
    @Getter@Setter
    private Integer pageSize=DEFAULT_PAGESIZE;

    private boolean isInit=false;   //该查询对象是否已初始化
    private String jointCondition="";     //拼接后的查询条件

    /**
     * 获取查询条件
     * @return  查询条件
     */
    public String getQuery(){
        if(!isInit){
            customCondition();
            isInit=true;
            //若没有查询条件，则返回空字符串
            if(conditions.size()==0){
                return "";
            }
            //拼接查询条件
            StringBuilder sb=new StringBuilder(100);
            sb.append(" WHERE ");
            String join = StringUtils.join(conditions, " AND ");
            sb.append(join);
            jointCondition =sb.toString();
        }
        return jointCondition;
    }

    /**
     * 初始化查询对象，既根据查询条件给conditions与params赋值
     */
    protected abstract void customCondition();

    /**
     * 给condition与params赋值
     * @param condition     查询条件
     * @param param     该条件对应的参数
     */
    protected void addConditonAndParams(String condition,Object ... param){
        conditions.add(condition);
        params.addAll(Arrays.asList(param));
    }

    /**
     * 获取分页查询指针的起始位置
     * @return
     */
    public int getFirstIndex(){
        return (currentPage-1)*pageSize;
    }

}
