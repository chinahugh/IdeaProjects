package com.tools.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 *  Jaxb对文件
 */
public final class XmlUtils {
    private static final Log logger = LogFactory.getLog (XmlUtils.class);
    public static String xmlToBean(Class clzss,Object obj,String encoding){
        StringWriter sw =new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(clzss);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.setProperty(Marshaller.JAXB_ENCODING, encoding);
            mar.marshal(obj,sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    public static <T> T beanToXml (String xml, Class <T> c)
    {
        T t = null;
        try
        {
            JAXBContext context = JAXBContext.newInstance (c);
            Unmarshaller unmarshaller = context.createUnmarshaller ();
            t = (T) unmarshaller.unmarshal (new StringReader(xml));
        }
        catch (Exception ex)
        {
            logger.error (ex.getMessage (), ex);
        }
        return t;
    }
    @Test
    public void test(){
        XmlBeanDemo xmlBeanDemo = new XmlBeanDemo();
        xmlBeanDemo.setAGE("123");
        xmlBeanDemo.getName().setKey("胡国晖");
        xmlBeanDemo.getName().setLll("圣诞节客户flak");
        xmlBeanDemo.setNamee("上的飞机和卡拉合适的");
        NAME name = new NAME();
        name.setLll("2sdf");
        name.setKey("sdfa");
        xmlBeanDemo.getNAMES().add(name);
        xmlBeanDemo.getNAMES().add(name);
        String gb2312 = xmlToBean(XmlBeanDemo.class, xmlBeanDemo, "gb2312");
        System.out.println(gb2312);
        XmlBeanDemo xmlBeanDemo1 = beanToXml(gb2312, XmlBeanDemo.class);
        System.out.println(xmlBeanDemo);
    }
}
