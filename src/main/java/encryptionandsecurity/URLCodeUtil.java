package encryptionandsecurity;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @Description: UTL编码:
 * @Author: Zohar
 * @Date: 2020/6/11 11:05
 * @Version: 1.0
 */
public class URLCodeUtil {

    public static void main(String[] args) throws UnsupportedEncodingException {
        encode();
        decode();

    }

    public static void encode() throws UnsupportedEncodingException {
        String encode = URLEncoder.encode("中文!", StandardCharsets.UTF_8.name());
        System.out.println(encode);
    }

    public static void decode() throws UnsupportedEncodingException {
        String decode = URLDecoder.decode("%E4%B8%AD%E6%96%87%21",StandardCharsets.UTF_8.name());
        System.out.println(decode);
    }
}
