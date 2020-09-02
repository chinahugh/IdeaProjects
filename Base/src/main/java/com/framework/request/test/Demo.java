//package com.framework.request.test;
//
//
//import net.dongliu.requests.*;
//import net.dongliu.requests.body.Part;
//import org.junit.Test;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Demo {
//
//    String url = "https://partnertest.mypicc.com.cn/ecooperation/HttpsRequest/insure.do";
//
//
//    @Test
//    public void t1() throws IOException {
//        StringBuffer sb = new StringBuffer();
//        readToBuffer(sb, "报文.xml");
//
//        Map<String, String> map = new HashMap<>();
//        map.put("interfaceNo", "001005");
//        byte[] gbks = sb.toString().getBytes("UTF-8");
//        String s_gbk = new String(gbks,"GBK");
//        System.out.println(s_gbk);
//        map.put("datas", s_gbk);
//
//        RawResponse send = Requests.post(url).params(map).send();
//
//        System.out.println(send.statusCode());
//
//        System.out.println("-------------------");
//
//        List<Header> headers = send.headers();
//        headers.forEach(x -> System.out.println(x.name() + " " + x.toString()));
//        headers.forEach(x -> System.out.println(x.name() + " " + x.toString()));
//        System.out.println("-------------------");
//        List<Cookie> cookies = send.cookies();
//        cookies.forEach(x -> System.out.println(x.toString()));
//        System.out.println("-------------------");
//        System.out.println(send.charset());
//
//
//        System.out.println(send.decompress());
//        System.out.println(send.statusLine());
//        System.out.println("-------------------");
////
////
//        Response<String> stringResponse = send.toTextResponse();
////        send.readToJson()
//        System.out.println(stringResponse.body().toString());
//        send.close();
//    }
//
//    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
//        InputStream is = new FileInputStream(filePath);
//        String line; // 用来保存每行读取的内容
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        line = reader.readLine(); // 读取第一行
//        while (line != null) { // 如果 line 为空说明读完了
//            buffer.append(line); // 将读到的内容添加到 buffer 中
//            buffer.append("\n"); // 添加换行符
//            line = reader.readLine(); // 读取下一行
//        }
//        reader.close();
//        is.close();
//    }
//
//
//}
