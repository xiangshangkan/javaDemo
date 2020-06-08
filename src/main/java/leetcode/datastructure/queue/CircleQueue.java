package leetcode.datastructure.queue;



/**
 * @Description: 循环队列：固定长度大小
 * @Author: Zohar
 * @Date: 2020/6/2 15:38
 * @Version: 1.0
 */
public class CircleQueue<T> {
    private Object[] data;

    private int head;
    private int tail;
    private int size;

    public CircleQueue(int size) {
       data = new Object[size];
       head = tail = -1;
       this.size = size;
    }


    /**
     * 向队列中添加数据
     */
    public  boolean enQueue(Object o) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = (++tail) % size;
        data[tail] = o;
        return true;
    }

    /**
     * 从队列中拿出数据
     */
    public T deQueue(){
       if (isEmpty()) {
           return null;
       }
       T t = (T)data[head];
       if (head == tail) {
           head = tail = -1;
       } else {
           head = (++head) % size;
       }
        return t;
    }

    /**
     * 从队列头获取数据
     */
    public T front(){
       if(isEmpty()) {
           return null;
       }
       return (T)data[head];
    }

    /**
     * 从队列尾获取数据
     */
    public T rear(){
        if (isEmpty()) {
            return null;
        }
        return (T)data[tail];
    }

    /**
     * 队列是否满了
     */
    public boolean isFull(){
        return head == (tail + 1) % size;
    }

    /**
     * 队列是否为空
     */
    public boolean isEmpty(){
        return head == -1;
    }

    public static void main(String[] args) {
        CircleQueue<Integer> queue = new CircleQueue<>(5);
        for (int i = 0; i < 6; i++) {
            System.out.println("从队列尾部取出数据" + queue.rear());
            System.out.println("向队列中插入数据" + i + (queue.enQueue(i) ? "成功" : "失败"));
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("从队列中取出数据" + queue.deQueue());
        }
    }

}
