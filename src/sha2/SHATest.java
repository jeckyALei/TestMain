package sha2;
import java.security.MessageDigest;  
import java.security.Security;  
  
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;  
  
import org.bouncycastle.jce.provider.BouncyCastleProvider;  
  
/** 
 * 工具类 
 */  
class SHACoder {  
    /** 
     * SHA-224消息摘要算法 
     */  
    public static String encodeSHA(byte[] data) throws Exception {  
        //加入BouncyCastle的支持  
        Security.addProvider(new BouncyCastleProvider());  
        // 初始化MessageDigest,SHA即SHA-1的简称  
        MessageDigest md = MessageDigest.getInstance("SHA-224");  
        // 执行摘要方法  
        byte[] digest = md.digest(data);  
        return new HexBinaryAdapter().marshal(digest);  
    }  
}  
  
/** 
 * 测试类 
 */  
public class SHATest {  
    public static void main(String[] args) throws Exception {  
       String testString="asd`12asd31";  
       System.out.println(SHACoder.encodeSHA(testString.getBytes()));  
    }  
}  