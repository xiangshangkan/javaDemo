package designPattern.StructurePattern.filterPattern;

import java.util.List;

/**
 * @Description: 为过滤标准(Criteria) 创建一个接口
 * @Auther: Administrator
 * @Date: 2018/9/15 11:32
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persions);
}
