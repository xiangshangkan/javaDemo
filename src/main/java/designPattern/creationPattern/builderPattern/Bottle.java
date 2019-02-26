package designPattern.creationPattern.builderPattern;

/**
* @Description:    创建一个实现食物包装的饼子类
* @Author:         zhouhui
* @CreateDate:
* @Version:        1.0
*/
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "pack:Bottle";
    }
}
