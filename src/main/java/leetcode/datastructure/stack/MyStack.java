package leetcode.datastructure.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:  栈 LIFO
 * @Author: Zohar
 * @Date: 2020/6/2 17:28
 * @Version: 1.0
 */
public class MyStack<T> {

    private List<T> data = new ArrayList<>();

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public void push(T t) {
        data.add(t);
    }

    public T pop(){
        if (isEmpty()) {
            return null;
        }
        T t = data.get(data.size() - 1);
        data.remove(data.size()-1);
        return t;
    }

    public static void main(String args[]) {
        MyStack<Integer> stack = new MyStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(stack.pop());
        }
    }

}
