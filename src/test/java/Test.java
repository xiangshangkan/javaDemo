import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/6/24 18:59
 * @Version 1.0
 */
public class Test {
    public static  void main(String[] args) {
        List<JSONObject> jsonList = new ArrayList<>();
        for (int i=0; i<3; i++) {
            JSONObject jsonMap = new JSONObject();
            jsonMap.put("empName","周");
            jsonMap.put("comment","好");
            jsonList.add(jsonMap);
        }
        System.out.println(JSONObject.toJSONString(jsonList));

    }


    public static void chineseEnglishNumber(){
        System.out.println("假假按揭");
    }



}
class Fest {

    private int i ;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
