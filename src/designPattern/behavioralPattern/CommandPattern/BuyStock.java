package designPattern.behavioralPattern.CommandPattern;
/**
 * 创建实现了Order接口的实现类:用来定义买的动作
 * */
public class BuyStock implements Order{
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
