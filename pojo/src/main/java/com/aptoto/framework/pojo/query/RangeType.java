package com.aptoto.framework.pojo.query;

/**
 * 指定某个查询条件的运算方式， 包括：
 * 等于、不等于、包含、不包含、大于、大于等于、小于、小于等于、为空、不为空、存在(IN)、不存在(NOT IN) 和 默认
 * 关于“默认查询方式的说明”：针对不同的属性类型定义不同的默认查询类型，如：字符型为模糊匹配、日期为大于匹配、数字为等于匹配等等
 * 
 * @author Orion
 * @since  0.2-RELEASE
 * 2017年4月8日
 */
public enum RangeType {
    /* 默认 */
    DEFAULT,
    /* 等于 */
    EQUAL,
    /* 不等于 */
    UNEQUAL,
    /* 包含 */
    INCLUDE,
    /* 不包含 */
    EXCLUDE,
    /* 大于 */
    GREATER,
    /* 大于等于 */
    EQUAL_GREATER,
    /* 小于 */
    LESS,
    /* 小于等于 */
    EQUAL_LESS,
    /* 为空 */
    NULL,
    /* 不为空 */
    NOT_NULL,
    /* in */
    IN,
    /* not in */
    NOT_IN;
    
    
    /**
     * 将字符转换为关系运算枚举对象
     * @param value 可以接受的字符：
     * --------------------------------------------------------------
     * | EQUAL, UNEQUAL, INCLUDE, EXCLUDE, GREATER, EQUAL_GREATER,  | 
     * | LESS, EQUAL_LESS, NULL, NOT_NULL, IN, NOT_IN               |
     * --------------------------------------------------------------
     * @return 返回相应的枚举对象，当输入参数不在上表范围时返回RangeType.DEFAULT
     * @since 0.2-RELEASE
     */
    public static RangeType obtainEnum(String value) {
        
        for (RangeType rangeType : RangeType.values()) {
            if (rangeType.name().equals(value))
                return rangeType;
        }
        
        return RangeType.DEFAULT;
    }
}
