package designPattern.behavioralPattern.nullObjectPattern;

/**
 * @ClassName NullObjectPatternDemo
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 15:37
 * @Version 1.0
 */
public class NullObjectPatternDemo {

    public static void main(String[] args) {
        AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("laura");

        System.out.println("Customers");
        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }

}
