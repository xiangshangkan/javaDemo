package javazh.utilzh;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorDemo {

    public void iteratorDemo1(){
        //创建一个集合
        Collection books = new HashSet();
        books.add("哈哈");
        books.add("嘿嘿");
        books.add("嘻嘻");
        //Collection集合继承了Iterable接口而forEach参数Consumer是一个函数式接口
        books.forEach(obj->System.out.println(obj));
        //获取books对应的迭代器
        Iterator iterator =books.iterator();
        //当迭代器内还有下一个值时
        while(iterator.hasNext()){
            String book = (String) iterator.next();
            System.out.println(book);
            if("嘿嘿".equals(book)){
                //从集合中删除上一次next()方法返回的元素
                iterator.remove();
            }
        }
        System.out.println(books);

    }
}
