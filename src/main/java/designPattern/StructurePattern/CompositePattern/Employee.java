package designPattern.StructurePattern.CompositePattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建Employee类，该类带有Employee对象的列表
 */
public class Employee {
    private String name;

    private String dept;

    private int salary;

    private List<Employee> subordinates;

    //构造函数
    public Employee(String name, String dept, int sal){
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e){
        subordinates.add(e);
    }

    public void remove(Employee e){
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
