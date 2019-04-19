package javazh.securityzh;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName MessageDigestDemo
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/4/19 10:26
 * @Version 1.0
 */
public class MessageDigestDemo {

   public static void main(String[] args) throws NoSuchAlgorithmException {

       String str = "unbelievable";
       byte[] strTemp = str.getBytes();
       System.out.println(strTemp);
       MessageDigest md = MessageDigest.getInstance("MD5");
       md.update(strTemp);
       byte[] b = md.digest();
       BigInteger bigInt = new BigInteger(1,b);
       System.out.println(bigInt.toString());

   }
}
