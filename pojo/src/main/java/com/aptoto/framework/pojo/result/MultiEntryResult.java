package com.aptoto.framework.pojo.result;

import java.util.ArrayList;
import java.util.List;

import com.aptoto.framework.IResponseAble;
import com.aptoto.framework.pojo.BizCode;

/**
 * 用于封装查询结果集合，并且结果对象只允许是同一类型的。
 * 一般来讲，作为集合类查询接口/查询服务的返回对象
 * @author Orion
 * @param <T>
 * @since 0.2-RELEASE
 * 2017年4月11日
 */
public class MultiEntryResult<T> implements IResponseAble {
    private static final long serialVersionUID = 6363786711368961547L;
    
    /* 查询结果集合 */
    private List<T> resultSet = new ArrayList<T>();
    /* 符合该查询条件的数据总量 */
    private Integer count = new Integer(0);
    
    /**
     * 添加指定的条目到结果集中
     * @param entry
     */
    public void addResult(T result) {
        if ( result != null )
            this.resultSet.add(result);
    }
    
    /**
     * @return the resultSet 查询结果集合
     */
    public List<T> getResultSet() {
        return resultSet;
    }


    /**
     * @param resultSet the 查询结果集合 to set
     */
    public void setResultSet(List<T> resultSet) {
        this.resultSet = resultSet;
    }


    /**
     * @return the count 符合该查询条件的数据总量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count the 符合该查询条件的数据总量 to set
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /*********************************************************
     *                                                       *
     *                      IResponseAble接口实现                                   *
     *                                                       *
     *********************************************************/
    
    /* 本次操作是否成功 */
    private Boolean successful = new Boolean(true);
    /* 处理结果代码 */
    private BizCode bizCode;
    /* 异常、违规操作、不符合流程等信息 */
    private String exceptionMessage;
    /* 提示信息，可直接在反馈给用户 */
    private String tips;
    
    @Override
    public Boolean isSuccessful() {
        return this.successful;
    }

    @Override
    public BizCode getBizCode() {
        return this.bizCode;
    }

    @Override
    public String getExceptionMessage() {
        return this.exceptionMessage;
    }

    @Override
    public String getTips() {
        return this.tips;
    }

    /**
     * @return the 本次操作是否成功
     */
    public Boolean getSuccessful() {
        return successful;
    }

    /**
     * @param successful the 本次操作是否成功 to set
     */
    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    /**
     * @param bizCode the 处理结果代码 to set
     */
    public void setBizCode(BizCode bizCode) {
        this.bizCode = bizCode;
    }

    /**
     * @param exceptionMessage the 异常、违规操作、不符合流程等信息 to set
     */
    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    /**
     * @param tips the 提示信息，可直接在反馈给用户 to set
     */
    public void setTips(String tips) {
        this.tips = tips;
    }
}
