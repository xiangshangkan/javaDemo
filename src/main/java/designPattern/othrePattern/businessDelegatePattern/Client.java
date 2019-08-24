package designPattern.othrePattern.businessDelegatePattern;

/**
 * @ClassName Client
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/11 09:18
 * @Version 1.0
 */
public class Client {

    BusinessDelegate businessService;

    public Client(BusinessDelegate businessDelegate) {
        this.businessService = businessDelegate;
    }

    public void doTask(){
        businessService.doTask();
    }
}
