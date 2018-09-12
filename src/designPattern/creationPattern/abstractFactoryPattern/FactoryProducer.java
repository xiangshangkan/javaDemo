package designPattern.creationPattern.abstractFactoryPattern;
/**
 * 创建一个工厂生成器，通过传递形状和颜色信息来获取工厂
 * */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice){
        if("Shape".equalsIgnoreCase(choice)){
            return new ShapeFactory();
        }else if("Color".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }
        return null;
    }
}
