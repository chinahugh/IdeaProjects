package com.framework.request.gs;

import net.dongliu.requests.*;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class gs {
    static String url = "https://partnertest.mypicc.com.cn/ecooperation/HttpsRequest/insure.do";

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        try {
            readToBuffer(sb, "报文.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }


        RawResponse send = Requests.post(url).body(sb.toString()).send();

        System.out.println(send.statusCode());


        Response<String> stringResponse = send.toTextResponse();
//        send.readToJson()
        System.out.println(stringResponse.body().toString());
        send.close();
    }

    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
    }

}
