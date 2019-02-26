package designPattern.behavioralPattern.CommandPattern;
/**
 * 实现命令窗口：定义一个卖的动作
 * */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
