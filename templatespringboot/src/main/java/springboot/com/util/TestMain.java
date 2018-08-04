package springboot.com.util;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * @Auther HUGH
 * @Date 2018/8/4
 * @Description TestMain
 */
public class TestMain {
    @Test
    public  void A() {
        for (int i = 1; i < 32; i++) {
            System.out.print("a.d"+i+".id,");
            System.out.print("a.d"+i+".m_data,");
            System.out.print("a.d"+i+".p_data,");
            System.out.print("a.d"+i+".m_tag,");
            System.out.print("a.d"+i+".p_tag,");
        }
    }
    @Test
    public void B(){
        String a="              ";
        String b=null;
        String c=" ";
        System.out.println(StringUtils.isEmpty(a));
        System.out.println(StringUtils.isEmpty(b));
        System.out.println(StringUtils.isEmpty(c));
    }
}
