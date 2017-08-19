package https;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
/**
 * Created by kingj on 2014/8/13.
 */
public class CertifcateUtils {
	private static String CRT="test.crt";
	private static String KEYSTORE="test.keystore";
	private static String PRIVATEPWD="testpwd1";
	private static String PUBLICPWD="testpwd2";
	private static String ALIAS="test";
	private static String keydir=CertifcateUtils.class.getResource("/").getPath();
    public static byte[] readCertifacates() throws Exception{
        CertificateFactory factory=CertificateFactory.getInstance("X.509");
        InputStream in=new FileInputStream(keydir+File.separator+CRT);
        java.security.cert.Certificate cate=factory.generateCertificate(in);
        return cate.getEncoded();
    }

    public static byte[] readPrivateKey() throws  Exception{
        KeyStore store=KeyStore.getInstance("JKS");
        InputStream in=new FileInputStream(keydir+File.separator+KEYSTORE);
        store.load(in,PRIVATEPWD.toCharArray());
        PrivateKey pk=(PrivateKey)store.getKey(PRIVATEPWD,PRIVATEPWD.toCharArray());
        return pk.getEncoded();
    }

    public static PrivateKey readPrivateKeys() throws  Exception{
        KeyStore store=KeyStore.getInstance("JKS");
        InputStream in=new FileInputStream(keydir+File.separator+KEYSTORE);
        store.load(in,PUBLICPWD.toCharArray());
        PrivateKey pk=(PrivateKey)store.getKey(ALIAS,PRIVATEPWD.toCharArray());
        return pk;
    }

    public static PublicKey readPublicKeys() throws  Exception{
        CertificateFactory factory=CertificateFactory.getInstance("X.509");
        InputStream in=new FileInputStream(keydir+File.separator+CRT);
        java.security.cert.Certificate cate=factory.generateCertificate(in);
        return cate.getPublicKey();
    }

    public static  java.security.cert.Certificate createCertiface(byte b[]) throws Exception{
        CertificateFactory factory=CertificateFactory.getInstance("X.509");
        InputStream in=new ByteArrayInputStream(b);
        java.security.cert.Certificate cate=factory.generateCertificate(in);
        return cate;
    }

    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }
}
