package thinkSome.泛型通配符;

/**
 * @ClassName Apple
 * @Description 泛型 与 通配符
 * @Author zhouhui
 * @Date 2019/3/21 09:03
 * @Version 1.0
 */
public class GenericWildCard{

    public static void main(String[] args) {
        Apple<String> apple = new Apple<>();
        apple.add("7");
        apple.add("1");
        apple.add("9");
        for(int i =0; i < apple.size(); i++) {
            System.out.println(apple.get(i));
        }
        System.out.println("-----------------------------");
        Apple.foreach(apple);

    }
}




class Apple<E> {

    private Object[] date = new Object[10];

    private int size = 0;

    public void add(E e) {
        date[size] = e;
        size ++;
    }

    public Object get(int index){
        return date[index];
    }

    public int size(){
        return this.size;
    }

    public static void foreach(Apple<?> apple){
        for(int i = 0; i < apple.size; i++){
            System.out.println(apple.get(i));
        }
    }
}


