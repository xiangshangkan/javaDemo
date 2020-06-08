package leetcode.datastructure.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 普通队列 FIFO  本实现，队列没有限制长度，有空间浪费
 * @Author: Zohar
 * @Date: 2020/6/2 15:13
 * @Version: 1.0
 */
public class MyQueue<T> {


    private List<T> data = new ArrayList<>();
    private int head = 0;

    /**
     * 向队列中插入数据
     * @param t
     * @return
     */
    public MyQueue<T> enQueue(T t) {
        data.add(t);
        return this;
    }

    /**
     * 从队列中拿出数据
     * @return
     */
    public T deQueue(){
        if (hasNext()) {
            return data.get(head++);
        }
        return null;
    }

    public boolean hasNext(){
        return data.size() > head;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue();
        queue.enQueue(1).enQueue(2);
        for (int i =0; i < 5; i++){
            if (queue.hasNext()) {
                System.out.println(queue.deQueue());
            } else {
                System.out.println("队列内没有值了");
            }
        }
    }
}
