package designPattern.behavioralPattern.mementoPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CareTaker
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 13:58
 * @Version 1.0
 */
public class CareTaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}
