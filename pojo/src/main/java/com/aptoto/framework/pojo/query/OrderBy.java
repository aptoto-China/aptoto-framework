package com.aptoto.framework.pojo.query;

/**
 * 定义查询结果某一属性的排序方式
 * 如：name asc, birthday desc
 * @author Orion
 * @since - 0.2-RELEASE
 * 2017年4月10日
 */
public class OrderBy {
    /* 要进行排序的属性名称 */
    private String attributeName;
    /* 排序方式 */
    private Rank rankType;
    
    public OrderBy() {}
    /**
     * 创建对象并赋值
     * @param attributeName 要进行排序的属性名称
     * @param rankType 排序方式
     */
    public OrderBy(String attributeName, Rank rankType) {
        super();
        this.attributeName = attributeName;
        this.rankType = rankType;
    }
    
    /*********************************************************
     *                                                       *
     *                  setter() & getter()                  *
     *                                                       *
     *********************************************************/
    
    /**
     * @return the 要进行排序的属性名称
     */
    public String getAttributeName() {
        return attributeName;
    }
    /**
     * @param attributeName the 要进行排序的属性名称 to set
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
    /**
     * @return the 排序方式
     */
    public Rank getRankType() {
        return rankType;
    }
    /**
     * @param rankType the 排序方式 to set
     */
    public void setRankType(Rank rankType) {
        this.rankType = rankType;
    }
}
