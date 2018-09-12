package designPattern.creationPattern.builderPattern;

/**
* @Description:    创建一个继承汉堡抽象类的肉汉堡类
* @Author:         zhouhui
* @CreateDate:
* @Version:        1.0
*/
public class MeetBurger extends Burger{
    @Override
    public String name() {
        return "MeetBurger";
    }

    @Override
    public float price() {
        return 20f;
    }
}
