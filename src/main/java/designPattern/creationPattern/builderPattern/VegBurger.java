package designPattern.creationPattern.builderPattern;

/**
* @Description:    创建了一个实现汉堡抽象类的蔬菜汉堡类
* @Author:         zhouhui
* @CreateDate:
* @Version:        1.0
*/
public class VegBurger extends Burger{


    @Override
    public String name() {
        return "VegBurger";
    }

    @Override
    public float price() {
        return 20;
    }
}
