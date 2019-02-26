package 克隆实现.clone实现克隆;


/**
 * 克隆：是指克隆对象，在堆空间内复制另一块内存，是完全的两个对象，不是复制指针的引用;
 * 浅克隆:是指克隆一个对象，而该对象的属性都是基本数据类型，只克隆出该对象；
 * 深度克隆:是指克隆对象的属性成员包含引用类型，（或者引用类型里还有引用类型）同时把引用类型克隆出来叫深度克隆
 * 克隆方法：实现Coloneable接口，或使用序列化
 */

public class Student implements Cloneable{

    private static final long serialVersionUID = -6694073835538195643L;

    private int number;

    private Address address;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student = null;
        //浅克隆
        student = (Student) super.clone();
        //深度克隆
        student.address = (Address) address.clone();
        return student;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address() ;
        address.setAdd("周辉");
        Student stu = new Student();
        stu.number = 1;
        stu.address = address;
        Student cloneStudent = (Student) stu.clone();
        Address changeAddress = new Address();
        address.setAdd("汪芳莉");
        stu.setAddress(changeAddress);
        stu.number = 2;
        System.out.println(stu + ""+ stu.getAddress());
        System.out.println(cloneStudent + "" + cloneStudent.getAddress());

    }
}

class Address implements Cloneable{

    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
