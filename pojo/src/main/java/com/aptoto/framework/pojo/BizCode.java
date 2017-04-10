package com.aptoto.framework.pojo;

/**
 * 系统运行结果代码
 * @author Orion
 * @since 0.2-RELEASE
 * 2017年4月10日
 */
public class BizCode implements java.io.Serializable {
    private static final long serialVersionUID = -1426413099166630916L;
    
    /* 结果代码:代码由两位英文字母和四位数字组成，AA~AZ开始的代码分配给底层框架和公共工具使用 */
    private final String code;
    /* 业务信息 */
    private final String info;
    /* 系统信息 */
    private final String debugInfo;
    
    /**
     * 业务代码说明：
     * 由两位英文字母和四位数字组成，两位英文字母表示模块（业务板块）代码，AA~AZ开始的代码分配给底层框架和公共模块，具体业务模块从BA开始
     * 四位数据由各模块自定义
     * @param code 结果代码
     * @param info 业务信息 该信息的定义必须能够被最终用户理解
     * @param debugInfo 系统信息 该信息的定义用于调试、异常判断、记录日志等
     */
    public BizCode(String code, String info, String debugInfo) {
        super();
        if (code==null)
            this.code = "";
        else
            this.code = code.trim();
        
        if (info==null)
            this.info = "";
        else
            this.info = info.trim();
        
        if (debugInfo==null)
            this.debugInfo = "";
        else
            this.debugInfo = debugInfo.trim();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof BizCode) {
            BizCode referenceObj = (BizCode)obj;
            if (code.equals(referenceObj.getCode()) && info.equals(referenceObj.getCode())
                    && debugInfo.equals(referenceObj.getDebugInfo()))
                return true;
        }
        return false;
    }
    
    /*********************************************************
     *                                                       *
     *                  setter() & getter()                  *
     *                                                       *
     *********************************************************/
    
    /**
     * @return the code 结果代码
     */
    public String getCode() {
        return code;
    }
    /**
     * 如果业务信息为空，则统一返回：
     * @return the info 业务信息
     */
    public String getInfo() {
        if (this.info==null || "".equals(this.info))
            return "系统未能处理您的请求";
        return info;
    }

    /**
     * @return the debugInfo 系统信息
     */
    public String getDebugInfo() {
        return debugInfo;
    }
}
