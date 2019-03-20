package designPattern.othrePattern.businessDelegatePattern;

/**
 * @ClassName JMSService
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/11 09:09
 * @Version 1.0
 */
public class JMSService implements BusinessService {
    @Override
    public void doProcessing() {
        System.out.println("Processing task by invoking JMS Service");
    }
}
