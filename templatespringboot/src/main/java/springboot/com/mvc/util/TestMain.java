package springboot.com.mvc.util;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/8/4
 * @Description TestMain
 */
public class TestMain {
    @Test
    public void A() {
        for (int i = 1; i < 32; i++) {
            System.out.print("a.d" + i + ".id,");
            System.out.print("a.d" + i + ".m_data,");
            System.out.print("a.d" + i + ".p_data,");
            System.out.print("a.d" + i + ".m_tag,");
            System.out.print("a.d" + i + ".p_tag,");
        }
    }

    @Test
    public void C() {
        for (int i = 1; i < 32; i++) {
            System.out.println("  if (proMain.getD" + i + "()!=null&&StringUtils.isNotBlank(proMain.getD" + i + "().getId())) {\n" +
                    "            proMain.setD" + i + "(proDataMapper.get(proMain.getD" + i + "().getId()));\n" +
                    "        }");
        }
    }

    @Test
    public void B() {
        String a = "              ";
        String b = null;
        String c = " ";
        System.out.println(StringUtils.isEmpty(a));
        System.out.println(StringUtils.isEmpty(b));
        System.out.println(StringUtils.isEmpty(c));
    }

    @Test
    public void mapreduce() {
        List<String> list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i+"");
        }
       // Integer integer = list.stream().map(i->new HashMap(i,1)).reduce((a, b) -> a + b).get();
    }
}
