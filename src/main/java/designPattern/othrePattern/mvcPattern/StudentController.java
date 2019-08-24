package designPattern.othrePattern.mvcPattern;

/**
 * @ClassName StudentController
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 16:44
 * @Version 1.0
 */
public class StudentController {

    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName(){
        return model.getName();
    }

    public void setStudentRollNo(String rollNo){
        model.setRollNo(rollNo);
    }

    public String getStudentRollno(){
        return model.getRollNo();
    }

    public void updateView(){
        view.printStudentDetail(model.getName(),model.getRollNo());
    }

}
