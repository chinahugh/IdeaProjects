package com.framework.request.test;


import net.dongliu.requests.*;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {

    String url = "https://web.gsrenbao.com:8443/baoxian/index.html";

    @Test
    public void t1() throws IOException {

        Map<String, Object> cookie = new HashMap<>();
        cookie.put("k1", "v1");
        cookie.put("k2", "v2");


        RawResponse send = Requests.get(url).cookies(cookie).send();
        System.out.println(send.statusCode());

        System.out.println("-------------------");

        List<Header> headers = send.headers();
        headers.forEach(x -> System.out.println(x.name() + " " + x.toString()));
        System.out.println("-------------------");
        List<Cookie> cookies = send.cookies();
        cookies.forEach(x -> System.out.println(x.toString()));
        System.out.println("-------------------");
        InputStream body = send.body();
        byte[] bs = new byte[1024];
        FileOutputStream fs = new FileOutputStream("aa.txt");
        while (body.read(bs) > 0) {
            fs.write(bs);
        }
        fs.close();
        System.out.println();
        System.out.println("-------------------");
//
//
//        Response<String> stringResponse = send.toTextResponse();
//        send.readToJson()
//        System.out.println(stringResponse.body().toString());
        send.close();
    }

    @Test
    public void session() {
        Map<String, Object> cookie = new HashMap<>();
        cookie.put("k1", "v1");
        cookie.put("k2", "v2");
        Session session = Requests.session();
        RawResponse send = session.get(url).cookies(cookie).send();
        System.out.println(send.statusCode());

        System.out.println("-------------------");

        List<Header> headers = send.headers();
        headers.forEach(x -> System.out.println(x.name() + " " + x.toString()));
        System.out.println("-------------------");
        List<Cookie> cookies = send.cookies();
        System.out.println(cookies);
        cookies.forEach(x -> System.out.println(x.toString()));
        System.out.println("-------------------");
        System.out.println(send.readToText());
        System.out.println("-------------------");
        in(session);
    }

    private void in(Session session) {
        RawResponse send = session.get(url).send();
        System.out.println(send.statusCode());

        System.out.println("-------------------");

        List<Header> headers = send.headers();
        headers.forEach(x -> System.out.println(x.name() + " " + x.toString()));
        System.out.println("-------------------");
        List<Cookie> cookies = send.cookies();
        System.out.println(cookies);
        cookies.forEach(x -> System.out.println(x.toString()));
        System.out.println("-------------------");
        System.out.println(send.readToText());
        System.out.println("-------------------");
    }
}
