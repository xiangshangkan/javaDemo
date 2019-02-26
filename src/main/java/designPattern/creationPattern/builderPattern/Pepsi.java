package designPattern.creationPattern.builderPattern;

/**
* @Description:    创建一个实现抽象冷饮类的百事可乐类
* @Author:         zhouhui
* @CreateDate:
* @Version:        1.0
*/
public class Pepsi extends ColdDrunk {

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 40f;
    }
}
