package com.aptoto.framework.pojo.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 指定特定属性具体的查询方式
 * 查询方式包含：属性标识+运算方式+符合条件的值（如，age>18）
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
    /* 符合条件的数据  */
    private List<String> targetValue;
    
    public ConditionItem() {
        super();
        this.targetValue = new ArrayList<String>();
    }
    
    /**
     * 构建查询条件对象
     * @param attributeName
     * @param rangeType
     * @param values
     */
    public ConditionItem(String attributeName, RangeType rangeType, String... values) {
        super();
        this.attributeName = attributeName;
        this.rangeType = rangeType;
        
        if (values==null || values.length==0)
            this.targetValue = new ArrayList<String>();
        else
            this.targetValue = Arrays.asList(values);
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
        boolean isTargetValueNull = targetValue==null || targetValue.size()==0 || targetValue.get(0)==null || "".equals(targetValue.get(0));
        boolean needValue = ! (RangeType.NULL.equals(rangeType) || RangeType.NOT_NULL.equals(rangeType) );
        if (needValue && isTargetValueNull )
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
    
    /**
     * 追加查询值
     * @param targetValue
     * @return 当前对象
     */
    public ConditionItem addTargetValue(String... targetValue) {
        if (targetValue==null || targetValue.length==0)
            this.targetValue.addAll(Arrays.asList(targetValue));
        return this;
    }
    
    /**
     * 适用于等于、包含、大于、小于等一元运算
     * @return 符合条件的数值
     */
    public String getSingleValue() {
        if ( targetValue==null || targetValue.size()==0 )
            return null;
        return targetValue.get(0);
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
     * @return the 符合条件的数据
     */
    public List<String> getTargetValue() {
        return targetValue;
    }

    /**
     * @param targetValue the 符合条件的数据 to set
     */
    public void setTargetValue(List<String> targetValue) {
        this.targetValue = targetValue;
    }
    
    /**
     * @param targetValue the 符合条件的数据 to set
     */
    public void setTargetValue(String... targetValue) {
        this.targetValue = Arrays.asList(targetValue);
    }
}
