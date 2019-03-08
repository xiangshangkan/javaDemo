package designPattern.behavioralPattern.mediatorPattern;

/**
 * @ClassName User
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 12:23
 * @Version 1.0
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
