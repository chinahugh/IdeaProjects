package springboot.template.global.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

/**
 * @Auther HUGH
 * @Date 2018/6/30
 * @Description Md5
 */
public class Md5Utils {
    @Test
    public void main() {
        String admin = getMd5("admin");
        System.out.println(admin.length());
    }

    public static String getMd5(String str) {
        Md5Hash admin = new Md5Hash(str);
        return admin.toString();
    }
}
