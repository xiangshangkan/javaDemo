package 克隆实现.序列化实现克隆;

import java.io.*;

/**
 * 基于序列化和反序列化实现的克隆不仅仅是深度克隆，更重要的是通过泛型限定，可以检查出要克隆的对象是否支持序列化，
 * 这项检查是编译器完成的，不是在运行时抛出异常，这种是方案明显优于使用Object类的clone方法克隆对象。
 * 让问题在编译的时候暴露出来总是优于把问题留到运行时。
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -1836559889696532604L;

    private String number;

    private Address address;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    /**
     * 将该对象序列化成流，因为写在流里的是对象的一个拷贝，而原对象任然存在于JVM中，所以
     * 利用这个特性可以实现对象的深拷贝
     */
    public Student myClone(){
        Student student = null;
        //可以捕获内存缓存区中的数据，转换成字节数组输出流。
        ByteArrayOutputStream  baos = new ByteArrayOutputStream();
        try {
            //从序列化流中读取对象（也成为序列化流）
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            //序列化
            oos.writeObject(this);
            //字节数组输入流
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            //反序列化流
            ObjectInputStream ois = new ObjectInputStream(bais);
            //反序列化得到深度克隆对象
            student = (Student)ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
      Address address = new Address();
      Student student = new Student();
      student.setAddress(address);
      Student cloneStudent = student.myClone();
      System.out.println(student + "" + student.getAddress());
      System.out.println(cloneStudent + "" + cloneStudent.getAddress());
    }

}


class Address implements  Serializable{//必须实现Serializable,否则会报异常

    private static final long serialVersionUID = 1938442560122225227L;

    private String add;

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
}