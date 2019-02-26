package designPattern.creationPattern.builderPattern;

/**
* @Description:   创建一个实现食物条目结构的抽象汉堡类
* @Author:         zhouhui
* @CreateDate:
* @Version:        1.0
*/
public abstract class Burger implements Item{


    @Override
    public Packing packing(){
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
