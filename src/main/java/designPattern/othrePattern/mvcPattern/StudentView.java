package designPattern.othrePattern.mvcPattern;

/**
 * @ClassName StudentView
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 13:39
 * @Version 1.0
 */
public class StudentView {

    public void printStudentDetail(String studentName, String studentRollNo){
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("Roll No : " + studentRollNo);
    }
}
