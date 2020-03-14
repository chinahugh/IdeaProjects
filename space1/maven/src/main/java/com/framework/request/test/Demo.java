package com.framework.request.test;


import net.dongliu.requests.*;
import org.junit.Test;

import java.io.IOException;
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
        headers.forEach(x -> System.out.println(x.name() + " " + x.toString()));
        System.out.println("-------------------");
        List<Cookie> cookies = send.cookies();
        cookies.forEach(x -> System.out.println(x.toString()));
        System.out.println("-------------------");
        System.out.println(send.charset());


        System.out.println(send.decompress());
        System.out.println(send.statusLine());
        System.out.println("-------------------");
//
//
//        Response<String> stringResponse = send.toTextResponse();
//        send.readToJson()
//        System.out.println(stringResponse.body().toString());
        send.close();
    }

}
