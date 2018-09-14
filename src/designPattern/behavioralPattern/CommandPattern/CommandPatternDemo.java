package designPattern.behavioralPattern.CommandPattern;

public class CommandPatternDemo {
    public static void main(String[] args){
        Stock abcStock = new Stock();
        //创建两个不同的动作对象
        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
