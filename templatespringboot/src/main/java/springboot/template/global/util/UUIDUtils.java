package springboot.template.global.util;

import java.util.UUID;

/**
 * @Auther HUGH
 * @Date 2018/7/29
 * @Description UUIDUtil
 */
public final class UUIDUtils {
    public static synchronized String getUUid(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("[-]", "");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String uUid = getUUid();
            System.out.println("uUid = " + uUid.length());
        }
    }
}
