package designPattern.behavioralPattern.nullObjectPattern;

/**
 * @ClassName CustomerFactory
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 15:33
 * @Version 1.0
 */
public class CustomerFactory {

    public static final String[] names = {"Rob","Joe","Julie"};

    public static  AbstractCustomer getCustomer(String name) {
        for(int i = 0; i< names.length; i++) {
            if(names[i].equalsIgnoreCase(name)){
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }


}
