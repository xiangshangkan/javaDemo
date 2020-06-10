package thinkSome.关键字;
import java.io.*;
/**
 * 将不需要序列化的属性前添加transient关键字，序列化对象时，这个属性就不会被序列化
 */
public class TransientTest {

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        //serializeUser();
        //deSerializeUser();

        externalizeStudent();
        deExternalizeStudent();
    }

    /**
     * 序列化
     */
    public static void serializeUser(){
        User user = new User();
        user.setName("im so stupid");
        user.setAge(20);
        try {
            File file = new File("D://测试文件夹/template");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(user);
            oos.close();
            System.out.println("添加了transient关键字序列化，age="+user.getAge());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化
     */
    public static void deSerializeUser() throws IOException, ClassNotFoundException {
        File file = new File("D://测试文件夹/template");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User newUser = (User) ois.readObject();
        System.out.print("添加了transient关键字反序列化，age=" + newUser.getAge());
    }

    /**
     * 序列化
     */
    public static void externalizeStudent() throws IOException {
        //Student stu = new Student("侯亮平");
        Student stu = new Student();
        stu.setName("候亮平");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D://测试文件夹/template2"));
        oos.writeObject(stu);
        oos.close();
        System.out.println("添加了transient关键字序列化，name="+stu.getName());
    }

    public static void deExternalizeStudent() throws IOException, ClassNotFoundException {
        File file = new File("D://测试文件夹/template2");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Student stu = (Student) ois.readObject();
        ois.close();
        System.out.println("添加了transient关键字反序列化，name="+stu.getName());
    }


}


/**
 * Serializable接口实现序列化与反序列化
 */
class User implements Serializable{

     static final long serialVersionUID = -3602769141543940172L;

    private transient int age;

    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}


/**
 * Externalizable接口实现序列化与反序列化
 */
class Student implements Externalizable {

   public Student() {}


    private transient String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 在该方法内指定序列化的属性
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
    }

    /**
     * 在该方法中指定反序列化的属性
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

