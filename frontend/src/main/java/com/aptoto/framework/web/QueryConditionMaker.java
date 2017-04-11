package com.aptoto.framework.web;

import javax.servlet.http.HttpServletRequest;

import com.aptoto.framework.pojo.query.QueryCondition;

/**
 * 创建查询条件对象
 * @author Orion
 * @since -
 * 2017年4月11日
 */
public class QueryConditionMaker {
    
    public static QueryCondition make(HttpServletRequest request) {
        return QueryConditionMaker.make(request, new String[0]);
    }
    
    public static QueryCondition make(HttpServletRequest request, String... expectAttribute) {
        return null;
    }
    
    public static <T> QueryCondition make(HttpServletRequest request, Class<T> type) {
        return null;
    }
}
