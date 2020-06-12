package encryptionandsecurity;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @Description: 哈希算法相关
 * @Author: Zohar
 * @Date: 2020/6/11 17:08
 * @Version: 1.0
 */
public class MessageDigestUtil {

    public static void main(String args[]) throws Exception {
         //创建一个MessageDigest实例：
        MessageDigest md = MessageDigest.getInstance("MD5");
        //反复调用update输入数据
        md.update("Hello".getBytes("UTF-8"));
        md.update("World".getBytes("UTF-8"));
        byte[] result = md.digest();
        System.out.println(new BigInteger(1,result).toString(16));
    }
}
