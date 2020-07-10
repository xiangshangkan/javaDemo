package netty.jsonIm;

import lombok.Data;

/**
 * @ClassName: JsonMsg
 * @Description: Json POJO类
 * @Author: Zohar
 * @Date: 2020/7/10 14:30
 * @Version: 1.0
 */
@Data
public class JsonMsg {

    private int id;

    private String content;

    /**
     * 序列化：调用通用方法，使用谷歌Gson转成字符串
     * @return
     */
    public String convertToJson() {
      return JsonUtil.pojoToJson(this);
    }

    /**
     * 反序列化：使用阿里FastJson 转成 Java POJO 对象
     * @param json
     * @return
     */
    public static JsonMsg parseFromJson(String json) {
        return JsonUtil.jsonToPojo(json,JsonMsg.class);
    }
}
