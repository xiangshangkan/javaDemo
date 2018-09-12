package designPattern.creationPattern.builderPattern;

/**
* @Description:    创建一个实现食物条目类的冷饮类
* @Author:         zhouhui
* @CreateDate:
* @Version:        1.0
*/
public abstract class ColdDrunk implements Item {

    /**
     * @Description   冷饮类的包装都是瓶子，故可以在抽象冷饮类中实现，而具体冷饮类可不实现该方法
     * @author      zhouhui
     * @param       []
     * @return      designPattern.creationPattern.builderPattern.Packing
     * @exception
     * @date        2018/9/12 11:03
     */
    @Override
    public Packing packing(){
        return new Bottle();
    }
}
