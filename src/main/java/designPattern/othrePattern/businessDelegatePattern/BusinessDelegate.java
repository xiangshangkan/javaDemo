package designPattern.othrePattern.businessDelegatePattern;

/**
 * @ClassName BusinessDelegate
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/11 09:13
 * @Version 1.0
 */
public class BusinessDelegate {

    private BusinessLookUp businessLookUp = new BusinessLookUp();
    private BusinessService businessService ;
    private String serviceType;

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void doTask(){
        businessService = businessLookUp.getBusinessService(serviceType);
        businessService.doProcessing();
    }
}
