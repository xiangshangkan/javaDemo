package designPattern.StructurePattern.filterPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 创建实现Criteria接口的实现类（具体标准：过滤掉女性，保留男性）
 * @Auther: Administrator
 * @Date: 2018/9/15 11:38
 */
public class CriteriaFemale implements  Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persions) {
        List<Person>  femalePersons = new ArrayList<Person>();
        if(null != persions && persions.size() > 0){
            for (Person person:persions) {
                if("FEMALE".equalsIgnoreCase(person.getGender())){
                    femalePersons.add(person);
                }
            }
        }
        return femalePersons;
    }
}
