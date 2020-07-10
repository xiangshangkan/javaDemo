package netty.jsonIm;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.GsonBuilder;

/**
 * @Description: 在Pojo序列化程Json字符串的应用场景，使用google的Gson ；在Json字符串反序列化成POJO的应用场景，使用阿里的FastJson库
 * @Author: Zohar
 * @Date: 2020/7/10 14:19
 * @Version: 1.0
 */
public class JsonUtil {

    static GsonBuilder gb = new GsonBuilder();
    static {
        //不需要html escape
        gb.disableHtmlEscaping();
    }

    /**
     * 序列化：使用谷歌Gson将POJO转成字符串
     * @param obj
     * @return
     */
    public static String pojoToJson(Object obj) {
        String json = gb.create().toJson(obj);
        return json;
    }

    /**
     * 反序列化：使用阿里Fastjson将字符串转成POJO对象
     * @param json
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T>T jsonToPojo(String json, Class<T> tClass) {
        T t = JSONObject.parseObject(json,tClass);
        return t;
    }
}
