package javazh.langzh;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassDemo {

    public static void  main(String[] args){
        Teacher teacher = new Teacher();
        System.out.println(teacher.getClass() == Teacher.class);
        System.out.println(teacher.getClass().equals(Teacher.class));
        System.out.println(teacher.getClass());
        System.out.println(Teacher.class);
        teacher.setName("周辉");
        teacher.setId(new Integer(4));
        getStr(Teacher.class,teacher);


    }

    public  static void getStr(Class cla,Object object){
        try {
            Teacher teacher;
            Student student;
            Field name = cla.getDeclaredField("name");
            Field id = cla.getDeclaredField("id");
            Method[] methods = cla.getMethods();
            Method getName = cla.getMethod("getName");
            Method getId = cla.getMethod("getId");
            if(Teacher.class.equals(cla) ){
                teacher = (Teacher) cla.newInstance();
                name.setAccessible(true);
                name.set(teacher,"3");
                System.out.println(name.get(teacher));
                name.get(teacher);
            }else if(Student.class .equals(cla) ){
                student = (Student) cla.newInstance();
            }
            Teacher teacher1 = (Teacher) object;
            System.out.println(teacher1.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


}

class Teacher{
    private String name;

    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

class Student{
    private String name;

    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}


