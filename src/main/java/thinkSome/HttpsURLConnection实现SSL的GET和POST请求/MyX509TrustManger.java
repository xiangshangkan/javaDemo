package thinkSome.HttpsURLConnection实现SSL的GET和POST请求;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @ClassName MyX509TrustManger
 * @Description 证书信任管理器（用于https请求）
 *              这个证书管理器的作用就是让它信任我们指定的证书，下面的代码意味着信任所有证书，不管是否权威机构颁发。
 * @Author zhouhui
 * @Date 2019/6/18 20:14
 * @Version 1.0
 */
public class MyX509TrustManger implements X509TrustManager{

    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
