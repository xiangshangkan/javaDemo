package designPattern.behavioralPattern.nullObjectPattern;

/**
 * @ClassName RealCustomer
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 15:28
 * @Version 1.0
 */
public class RealCustomer extends AbstractCustomer {

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
