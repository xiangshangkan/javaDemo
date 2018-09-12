package designPattern.creationPattern.builderPattern;

/**
* @Description:    创建一个实现冷饮抽象类的可口可乐类
* @Author:         zhouhui
* @CreateDate:
* @Version:        1.0
*/
public class Coke extends  ColdDrunk {

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30f;
    }
}
