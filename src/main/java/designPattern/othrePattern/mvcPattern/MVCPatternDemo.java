package designPattern.othrePattern.mvcPattern;

/**
 * @ClassName MVCPatternDemp
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 16:50
 * @Version 1.0
 */
public class MVCPatternDemo {

    public static void main(String[] arg) {

        //从数据库获取学生记录
        Student model =retriveStudentFromDataBase();

        //创建一个视图：把学生详细信息输出到控制台
        StudentView view = new StudentView();

        StudentController  controller = new StudentController(model,view);

        controller.updateView();

        //更新模型数据
        controller.setStudentName("John");

        controller.updateView();
    }

    private static Student retriveStudentFromDataBase(){
        Student student = new Student();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}
