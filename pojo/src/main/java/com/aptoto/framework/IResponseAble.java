package com.aptoto.framework;

import java.io.Serializable;

import com.aptoto.framework.pojo.BizCode;

/**
 * 反馈执行结果的基本信息
 * @author Orion
 * @since 0.2-RELEASE
 * 2017年4月11日
 */
public interface IResponseAble extends Serializable {
    
    /**
     * @return 本次操作是否成功
     */
    Boolean isSuccessful();
    
    /**
     * @return 系统运行结果代码
     */
    BizCode getBizCode();
    
    /**
     * @return 异常、违规操作、不符合流程等信息
     */
    String getExceptionMessage();
    
    /**
     * @return 提示信息，可直接在反馈给用户
     */
    String getTips();
}
