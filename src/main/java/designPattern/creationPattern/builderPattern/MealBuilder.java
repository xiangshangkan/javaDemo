package designPattern.creationPattern.builderPattern;

/**
 * @Description:
 * @Auther: Administrator
 * @Date: 2018/9/12 11:25
 */
public class MealBuilder {

    /**
    * @Description   素食套餐
    */
    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        Item vegItem = new VegBurger();
        Item cokeItem = new Coke();
        meal.addItem(vegItem);
        meal.addItem(cokeItem);
        return meal;
    }

    /**
    * @Description   肉食套餐
    */
    public  Meal prepareMeetMeal(){
        Meal meal = new Meal();
        Item meetItem = new MeetBurger();
        Item pePsiItem = new Pepsi();
        meal.addItem(meetItem);
        meal.addItem(pePsiItem);
        return meal;
    }

    public static  void main(String[] args){
       MealBuilder mealBuilder = new MealBuilder();
       mealBuilder.prepareMeetMeal().showMeal();
       mealBuilder.prepareVegMeal().showMeal();
    }
}
