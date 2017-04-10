package com.aptoto.framework.pojo;

/**
 * 底层框架业务代码
 * @author Orion
 * @since 0.2-RELEASE
 * 2017年4月10日
 */
public class AABizCode {
    
    /** 按预期完成业务，无如何系统异常或业务异常 **/
    public static final BizCode AA0001 = new BizCode("AA0001","完成","完整执行，无如何系统异常或业务异常");
    /** 输入的参数不完整 **/
    public static final BizCode AA0002 = new BizCode("AA0002","请检查内容是否完整","参数不完整");
    /** 要求返回的记录数大于允许返回的最大记录数 **/
    public static final BizCode AA0003 = new BizCode("AA0003","每页返回数据量大于允许范围","超出允许的数据量");
    
    private AABizCode() {
        super();
    }
}
