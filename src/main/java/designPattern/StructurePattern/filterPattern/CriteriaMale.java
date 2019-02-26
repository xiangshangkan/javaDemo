package designPattern.StructurePattern.filterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 创建实现了Criteria接口的实现类(具体的标准:过滤掉男性，保留女性)
 * @Auther: Administrator
 * @Date: 2018/9/15 11:34
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persions) {
        List<Person> malePersons = new ArrayList<Person>();
        if(null != persions && persions.size() > 0){
            for(Person person :persions){
                if(person.getGender().equalsIgnoreCase("MALE")){
                    malePersons.add(person);
                }
            }
        }
        return malePersons;
    }
}
