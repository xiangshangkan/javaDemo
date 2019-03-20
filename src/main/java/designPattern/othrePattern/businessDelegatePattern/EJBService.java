package designPattern.othrePattern.businessDelegatePattern;

/**
 * @ClassName EJBServiceJava
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/11 09:06
 * @Version 1.0
 */
public class EJBService implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking EJB Service");
    }
}
