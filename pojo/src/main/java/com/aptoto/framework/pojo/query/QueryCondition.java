package com.aptoto.framework.pojo.query;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装完整的查询条件，包含有：分页、结果排序方式、查询条件元素
 * @author Orion
 * @since 0.2-RELEASE
 * 2017年4月8日
 */
public class QueryCondition implements java.io.Serializable {
    private static final long serialVersionUID = 3247361190231251647L;
    
    /* 页码，数据查询定位到第几页，默认值为“1” */
    private Integer pageNO = new Integer(1);
    /* 每页返回记录数，默认值为40，-1表示全部返回 */
    private Integer pageSize = new Integer(40);
    /* 允许返回最大记录数，默认值为100，-1表示无限制 */
    private Integer pageSizeLimit = new Integer(100);
    
    /* 查询结果排序方式 */
    private List<OrderBy> orderBySet = new ArrayList<OrderBy>();
    
    /* 查询条件集合 */
    private List<ConditionItem> conditions = new ArrayList<ConditionItem>();
    
    /**
     * 添加排序方式，为null则忽略
     * @param orderBy 指定属性的排序方式
     * @return 当前对象
     */
    public QueryCondition addOrderBy(OrderBy orderBy) {
        if (orderBy != null)
            this.orderBySet.add(orderBy);
        
        return this;
    }
    
    /**
     * 添加查询条件，为null则忽略
     * @param condition 指定属性的查询方式
     * @return 当前对象
     */
    public QueryCondition addCondition(ConditionItem condition) {
        if (condition != null)
            this.conditions.add(condition);
        return this;
    }
    
    /**
     * 清楚所有不符合数据规则的查询条件
     */
    public void cleanDirtyCondition() {
        for (ConditionItem item : this.conditions) {
            if ( !item.selfExamination() )
                this.conditions.remove(item);
        }
    }
    
    /**
     * 情况所有查询条件
     */
    public void cleanAllCondition() {
        this.conditions.clear();
    }
    
    /**
     * 清空所有排序方式
     */
    public void cleanAllOrderBy() {
        this.orderBySet.clear();
    }
    
    /**
     * 检查每页返回数量是否超过限制
     * @return T/F
     */
    public boolean checkPageSize() {
        if (this.getPageSizeLimit() == -1)
            return true;
        
        if (this.getPageSize()>=0 && this.getPageSize()<=this.getPageSizeLimit())
            return true;
        
        return true;
    }

    /**
     * @return the 页码，数据查询定位到第几页
     */
    public Integer getPageNO() {
        return pageNO;
    }

    /**
     * @param pageNO the 页码 to set， 数据查询定位到第几页，默认值为“1”
     */
    public void setPageNO(Integer pageNO) {
        this.pageNO = pageNO;
    }

    /**
     * @return the 每页返回记录数， 默认值为40， -1表示全部返回
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 数据规则：
     * 如果该值大于允许返回最大记录数{@link #getPageSizeLimit()}，系统将拒绝执行并返回错误代码
     * 如果要求返回所有数据，但允许返回最大记录数未设置为“无限制”{@link #getPageSizeLimit()}，则系统将拒绝执行并返回错误代码
     * @param pageSize the 每页返回记录数 to set， 默认值为40， -1表示全部返回
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    
    /**
     * @return the 允许返回最大记录数.默认值为100，-1表示无限制
     */
    public Integer getPageSizeLimit() {
        return pageSizeLimit;
    }

    /**
     * @param pageSizeLimit the 允许返回最大记录数 to set，默认值为100，-1表示无限制
     */
    public void setPageSizeLimit(Integer pageSizeLimit) {
        this.pageSizeLimit = pageSizeLimit;
    }

    /**
     * @return the orderBySet
     */
    public List<OrderBy> getOrderBySet() {
        return orderBySet;
    }

    /**
     * @param orderBySet the orderBySet to set
     */
    public void setOrderBySet(List<OrderBy> orderBySet) {
        this.orderBySet = orderBySet;
    }

    /**
     * @return the conditions
     */
    public List<ConditionItem> getConditions() {
        return conditions;
    }

    /**
     * @param conditions the conditions to set
     */
    public void setConditions(List<ConditionItem> conditions) {
        this.conditions = conditions;
    }
    
    
}
