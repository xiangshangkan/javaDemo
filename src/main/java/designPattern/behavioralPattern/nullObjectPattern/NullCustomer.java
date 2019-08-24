package designPattern.behavioralPattern.nullObjectPattern;

/**
 * @ClassName NullCustomer
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 15:31
 * @Version 1.0
 */
public class NullCustomer extends AbstractCustomer {
    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getName() {
        return "Not Available in Customer DataBase";
    }
}
