package encryptionandsecurity;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * @Description: 引用哈希算法和加密算法第三方库
 * @Author: Zohar
 * @Date: 2020/6/12 10:13
 * @Version: 1.0
 */
public class BouncyCastleUtil {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //注册BouncyCastle
        Security.addProvider(new BouncyCastleProvider());
        //按名称正常调用
        MessageDigest md = MessageDigest.getInstance("RipeMD160");
        md.update("HelloWorld".getBytes("UTF-8"));
        byte[] result = md.digest();
        System.out.println(new BigInteger(1,result).toString(16));
    }
}
