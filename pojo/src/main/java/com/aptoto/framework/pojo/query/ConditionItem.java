package com.aptoto.framework.pojo.query;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 指定特定属性具体的查询方式
 * 查询方式包含：属性标识+运算方式+符合条件的值（如，age>18）
 * 数据规则：
 * 一元运算的值可以赋给targetValue或multiValue[0]，targetValue值得优先级较高
 * 多元运算的值可以赋给multiValue
 * 是否为空检查可以赋值null
 * 
 * @author Orion
 * @since 0.2-RELEASE
 * 2017年4月8日
 */
public class ConditionItem implements java.io.Serializable {
    private static final long serialVersionUID = -1559059899353052958L;
    
    /* 针对哪个属性进行查询 */
    private String attributeName;
    /* 运算方式 @see com.aptoto.framework.pojo.query.RangeType */
    private RangeType rangeType;
    /* 符合条件的数据（一元运算）  */
    private String targetValue;
    /* 符合条件的数据（多元运算）  */
    private List<String> multiValue;
    
    public ConditionItem() {}
    
    /**
     * 构建查询条件对象
     * 该查询主要用于封装一元运算 和 状态运算（是否为空）
     * 另外也可以用于封装元运算中的一元
     * @param attributeName
     * @param rangeType
     * @param targetValue
     * @since 0.2-RELEASE
     */
    public ConditionItem(String attributeName, RangeType rangeType, String targetValue) {
        super();
        this.attributeName = attributeName;
        this.rangeType = rangeType;
        this.targetValue = targetValue;
    }
    
    /**
     * 构建查询条件对象
     * 该查询主要用于封装多元运算
     * 另外也可以用于封装一元运算（值赋给数组下标为0的元素） 和 状态运算（是否为空）
     * @param attributeName
     * @param rangeType
     * @param multiValue
     * @since 0.2-RELEASE
     */
    public ConditionItem(String attributeName, RangeType rangeType, String[] multiValue) {
        super();
        this.attributeName = attributeName;
        this.rangeType = rangeType;
        if (multiValue!=null)
            this.multiValue = Arrays.asList(multiValue);
    }
    
    /**
     * 查询条件自检--检查对象本身数据完整性
     * @return true:完整
     * @since 0.2-RELEASE
     */
    public boolean selfExamination() {
        //查询属性不可空
        if ( attributeName==null || "".equals(attributeName) )
            return false;
        
        //运算方式不可空
        if ( rangeType == null )
            return false;
        
        //运算值不可为空（是否为空除外）
        boolean isTargetValueNull = targetValue==null || "".equals(targetValue);
        boolean isMultiValueNull = multiValue==null || multiValue.size()==0 || multiValue.get(0)==null || "".equals(multiValue.get(0));
        boolean needValue = ! (RangeType.NULL.equals(rangeType) || RangeType.NOT_NULL.equals(rangeType) );
        if (needValue && isTargetValueNull && isMultiValueNull )
            return false;
        
        return true;
    }
    
    @Override
    public boolean equals(Object obj) {
        String currentObjJson = this.toString();
        String referenceObjJson = new GsonBuilder().create().toJson(obj);
        //暂未知是否需要重写
        return currentObjJson.equals(referenceObjJson);
    }
    
    @Override
    public String toString() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }


    /*********************************************************
     *                                                       *
     *                  setter() & getter()                  *
     *                                                       *
     *********************************************************/
    
    /**
     * @return the 针对哪个属性进行查询
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * @param attributeName the 针对哪个属性进行查询 to set
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    /**
     * @return the 运算方式
     */
    public RangeType getRangeType() {
        return rangeType;
    }

    /**
     * @param rangeType the 运算方式 to set
     */
    public void setRangeType(RangeType rangeType) {
        this.rangeType = rangeType;
    }

    /**
     * @return the 符合条件的数据（一元运算）
     */
    public String getTargetValue() {
        return targetValue;
    }

    /**
     * @param targetValue the 符合条件的数据（一元运算） to set
     */
    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
    }

    /**
     * @return the 符合条件的数据（多元运算）
     */
    public List<String> getMultiValue() {
        return multiValue;
    }

    /**
     * @param multiValue the 符合条件的数据（多元运算） to set
     */
    public void setMultiValue(String... multiValue) {
        this.multiValue = Arrays.asList(multiValue);
    }
    
    /**
     * @param multiValue the 符合条件的数据（多元运算） to set
     */
    public void setMultiValue(List<String> multiValue) {
        this.multiValue = multiValue;
    }
}
