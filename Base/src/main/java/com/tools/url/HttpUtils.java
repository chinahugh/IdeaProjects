package com.tools.url;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.LinkedList;
import java.util.List;

public class HttpUtils {
    public static void main(String[] args) {

        /**
         * 携带Cookies、参数、Header的POST请求
         */
        try {
            // 1:----设置传递参数----
            // 创建post对象
            HttpGet post = new HttpGet("http://127.0.0.1/zhufu/index.html");
            // 创建集合 添加参数
            List<NameValuePair> list = new LinkedList<>();
            BasicNameValuePair param1 = new BasicNameValuePair("name", "Anndy");
            BasicNameValuePair param2 = new BasicNameValuePair("age", "18");
            list.add(param1);
            list.add(param2);
            // 使用URL实体转换工具
            UrlEncodedFormEntity entityParam = new UrlEncodedFormEntity(list, "UTF-8");
          //  post.setEntity(entityParam);

            // 2:----设置Header信息----
            // 设置Headers头信息
            post.addHeader("context-Type", "AABB");
            post.addHeader("Agent", "CCDD");
            post.addHeader("Connection", "keep-alive");
            post.addHeader("Content-Type", "application/x-www-form-urlencoded");

            // 3：----设置Cookie信息----
            // 创建CookieStore对象用来管理cookie
            CookieStore cookieStore = new BasicCookieStore();
            // new BasicClientCookie对象 用来注入cookie
            BasicClientCookie cookie = new BasicClientCookie("SessionID", "11AABB22");

            cookie.setDomain("localhost");// 设置cookie的作用域

            cookieStore.addCookie(cookie);// 将cookie添加到cookieStore中

            HttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

            // 执行Post请求
            HttpResponse response = client.execute(post);
            // 将response对象转换成String类型
            String responseStr = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(responseStr);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
