package springboot.template.global.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @Auther HUGH
 * @Date 2018/6/30
 * @Description Md5
 */
public class Md5Util {
    public static void main(String[] args) {
        Md5Hash admin = new Md5Hash("admin");
        System.out.println(admin.toString());
    }
}
