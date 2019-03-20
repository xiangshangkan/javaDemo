package designPattern.othrePattern.businessDelegatePattern;

/**
 * @ClassName BusinessDelegatePatternDemo
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/11 09:20
 * @Version 1.0
 */
public class BusinessDelegatePatternDemo {

    public static void main(String[] args){
        BusinessDelegate  businessDelegate = new BusinessDelegate();
        businessDelegate.setServiceType("EJB");

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setServiceType("JMS");
        client.doTask();
    }
}
