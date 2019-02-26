package designPattern.StructurePattern.filterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:  调用过滤的具体标准(两种过滤标准的并集)
 * @Auther: Administrator
 * @Date: 2018/9/15 11:53
 */
public class AndCriteria implements Criteria{
    private Criteria criteria;

    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria){
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }
    @Override
    public List<Person> meetCriteria(List<Person> persions) {
        List<Person> firstCriteriaItem;
        List<Person> otherCriteriaItem;
        if(null == persions || persions.size() > 0){
            return null;
        }else{
            firstCriteriaItem = criteria.meetCriteria(persions);
            otherCriteriaItem = otherCriteria.meetCriteria(persions);
        }
        for (Person person:firstCriteriaItem) {
            if(!otherCriteriaItem.contains(person)){
                otherCriteriaItem.add(person);
            }
        }
        return otherCriteriaItem;
    }
}
