package com.aptoto.framework.pojo.result;

import com.aptoto.framework.IResponseAble;
import com.aptoto.framework.pojo.BizCode;

/**
 * 用于封装查询结果实体
 * 一般来讲，作为获取指定数据接口/服务的返回对象
 * @author Orion
 * @since 0.2-RELEASE
 * 2017年4月11日
 */
public class SingleEntryResult<T> implements IResponseAble {
    private static final long serialVersionUID = 8808131184771769446L;
    
    /* 查询结果实体 */
    private T result;
    
    /**
     * @return the result 查询结果实体
     */
    public T getResult() {
        return result;
    }

    /**
     * @param result the 查询结果实体 to set
     */
    public void setResult(T result) {
        this.result = result;
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
