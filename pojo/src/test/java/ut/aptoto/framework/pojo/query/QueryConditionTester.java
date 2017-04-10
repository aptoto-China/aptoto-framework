package ut.aptoto.framework.pojo.query;

import static org.junit.Assert.*;

import org.junit.Test;

import com.aptoto.framework.pojo.query.ConditionItem;
import com.aptoto.framework.pojo.query.QueryCondition;
import com.aptoto.framework.pojo.query.RangeType;

public class QueryConditionTester {
    
    @Test
    public void cleanDirtyCondition() {
        QueryCondition condition = new QueryCondition();
        condition.addCondition(new ConditionItem("name",RangeType.INCLUDE,null));
        condition.addCondition(new ConditionItem("age",RangeType.LESS,"25"));
        
        assertEquals("清理前，预期包含2个查询条件，实际上为"+condition.getConditions().size()+"个查询条件", 2, condition.getConditions().size());
        
        condition.cleanDirtyCondition();
        assertEquals("清理后，预期包含1个查询条件，实际上为"+condition.getConditions().size()+"个查询条件", 1, condition.getConditions().size());
    }
}
