package encryptionandsecurity;

import java.util.Arrays;
import java.util.Base64;

/**
 * @Description: Base64 编码,
 * @Author: Zohar
 * @Date: 2020/6/10 20:54
 * @Version: 1.0
 */
public class Base64Util {

    public static void main(String args[]) {
        //encode();
        //decode();
        //encode2();
        urlEncode();
    }

    public static void encode(){
        byte[] input = new byte[]{(byte)0xe4,(byte)0xb8,(byte)0xad};
        String b64encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded);
    }

    public static void decode(){
        byte[] output = Base64.getDecoder().decode("5Lit");
        System.out.println(Arrays.toString(output));
    }

    public static void encode2(){
        byte[] input = new byte[]{(byte)0xe4};
        String b64encoded = Base64.getEncoder().encodeToString(input);
        String b64encoded2 = Base64.getEncoder().withoutPadding().encodeToString(input);
        System.out.println("b64encoded：" +b64encoded );
        System.out.println("b64encoded2：" +b64encoded2 );
        byte[] output = Base64.getDecoder().decode(b64encoded2);
        System.out.println(Arrays.toString(output));
    }

    public static void urlEncode(){
        byte[] input = new byte[] { 0x01, 0x02, 0x7f, 0x00 };
        String b64encoded = Base64.getUrlEncoder().encodeToString(input);
        System.out.println("b64encoded：" + b64encoded);
        byte[] output = Base64.getUrlDecoder().decode(b64encoded);
        System.out.println(Arrays.toString(output));
    }
}
