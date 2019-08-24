package designPattern.behavioralPattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Subject
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 14:19
 * @Version 1.0
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observer.update();
    }

    public void notifyAllObservers(){
        for(Observer observer : observers) {
            observer.update();
        }
    }
}
