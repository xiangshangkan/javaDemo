package encryptionandsecurity;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * @Description: 对称加密
 * @Author: Zohar
 * @Date: 2020/6/12 14:13
 * @Version: 1.0
 */
public class SymmetryEncryption {

    public static void main(String[] args) throws Exception{

        String message = "hello world";
        //128位密钥
        byte[] key = "1234567890abcdef".getBytes("UTF-8");
        //加密
        byte[] data = message.getBytes("UTF-8");
        byte[] encrypted = encrypt(key,data);
        System.out.println("Encrypted：" + Base64.getEncoder().encodeToString(encrypted));
        //解密
        byte[] decrypted = decrypt(key,encrypted);
        System.out.println("Decrypted：" + new String(decrypted,"UTF-8"));
    }


    //加密
    public static byte[] encrypt(byte[] key,byte[] input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key,"AES");
        cipher.init(Cipher.ENCRYPT_MODE,keySpec);
        return cipher.doFinal(input);
    }

    //解密
    public static  byte[] decrypt(byte[] key, byte[] input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key,"AES");
        cipher.init(Cipher.DECRYPT_MODE,keySpec);
        return cipher.doFinal(input);
    }

}
