package designPattern.behavioralPattern.IteratorPattern;

/**
 * @ClassName IteratorPatternDemo
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 11:38
 * @Version 1.0
 */
public class IteratorPatternDemo {

    public static void main(String[] args){
        NameRepository namesRepository = new NameRepository();

        for (Iterator itr = namesRepository.getIterator();itr.hasNext();){
            String name = (String)itr.next();
            System.out.println("Name:" + name);
        }
    }
}
