package netty.jsonIm;

import org.testng.annotations.Test;

import java.util.logging.Logger;

/**
 * @Description: Json 与 POJO 对象转换测试
 * @Author: Zohar
 * @Date: 2020/7/10 14:37
 * @Version: 1.0
 */
public class JsonMsgDemo {

    /**
     * 构建 Json对象
     */
    public JsonMsg buildMsg(){
        JsonMsg user = new JsonMsg();
        user.setId(10000);
        user.setContent("疯狂创客圈：高性能学习社群");
        return user;
    }

    @Test
    public void serAndDesr(){
        JsonMsg message = buildMsg();
        //将Pojo对象，序列化成字符串
        String json = message.convertToJson();
        //可以用于网络传输，保存到内存或外存
        Logger.getGlobal().info("json:=" + json);

        //JSON 字符串，反序列化成POJO对象
        JsonMsg inMsg = JsonMsg.parseFromJson(json);
        Logger.getGlobal().info("id:=" + inMsg.getId());
        Logger.getGlobal().info("content:=" + inMsg.getContent());
    }
}
