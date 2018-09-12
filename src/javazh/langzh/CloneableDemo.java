package javazh.langzh;


/**
 * @Description：  要实现对象的拷贝，需要重载父类Object的clone()方法，并且实现Cloneable接口（否则CloneNotSupportedException），
 * @Auther: Administrator
 * @Date: 2018/9/12 11:59
 */
public class CloneableDemo implements Cloneable{

    private Integer aInt;
    CloneableDemo(Integer aInt){
        this.aInt = aInt;
    }

    @Override
    public CloneableDemo clone(){
        CloneableDemo cloneableDemo = null;
        try{
            cloneableDemo = (CloneableDemo) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloneableDemo;
    }

    /**
    * @Description   拷贝对象生成一个新的对象而不是对象的引用，并且该拷贝对象包含原对象的信息
    * @author      作者姓名
    * @param
    * @return
    * @exception
    * @date        2018/9/12 13:40
    */
    public static void main(String[] args){
        CloneableDemo demo = new CloneableDemo(10);
        CloneableDemo demo1 = demo;
        CloneableDemo demo2 = demo.clone();
        System.out.println(demo == demo1);
        System.out.println(demo == demo2);
    }
}
