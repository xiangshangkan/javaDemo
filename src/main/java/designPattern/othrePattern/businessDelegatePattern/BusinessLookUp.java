package designPattern.othrePattern.businessDelegatePattern;

/**
 * @ClassName BusinessLookUp
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/11 09:11
 * @Version 1.0
 */
public class BusinessLookUp {

    public BusinessService getBusinessService(String serviceType){
        if(serviceType.equalsIgnoreCase("EJB")){
            return new EJBService();
        } else {
            return new JMSService();
        }
    }
}
