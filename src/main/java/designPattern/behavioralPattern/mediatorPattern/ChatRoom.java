package designPattern.behavioralPattern.mediatorPattern;

import java.util.Date;

/**
 * @ClassName ChatRoom
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/7 12:21
 * @Version 1.0
 */
public class ChatRoom {

    public static void showMessage(User user, String message){
        System.out.println(new Date().toString() + "[" + user.getName() + "]:"  + message);
    }
}
