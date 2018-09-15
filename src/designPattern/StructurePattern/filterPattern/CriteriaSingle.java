package designPattern.StructurePattern.filterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:  实现标准Criteria接口（具体标准：保留单身人）
 * @Auther: Administrator
 * @Date: 2018/9/15 11:45
 */
public class CriteriaSingle  implements  Criteria{

    @Override
    public List<Person> meetCriteria(List<Person> persions) {
        List<Person> singlePersons = new ArrayList<Person>();
        if(null != persions && persions.size() >0 ){
            for (Person person:persions) {
                if("SINGLE".equalsIgnoreCase(person.getMaritalStatus())){
                    singlePersons.add(person);
                }
            }
        }
        return singlePersons;
    }
}
