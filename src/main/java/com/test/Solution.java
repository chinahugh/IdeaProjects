package com.test;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.http.HttpUtil;

public class Solution {
    public static void main(String[] args) {
//getlocal();

        String url = "https://apis.map.qq.com";
        String url2 = "/ws/geocoder/v1?key=AHPBZ-WZLLJ-46MFZ-KKLQW-RHG4J-JRBLI&location=22.316555,114.174328";
        String s1 = new MD5().digestHex(url2 + "yvcFoIg3ogcwpJxf0fp3WyxYo7GYuhq").toString();

        System.out.println(url + url2 + "&sig=" + s1);
        String s = HttpUtil.get(url + url2 + "&sig=" + s1);
        System.out.println(s);
}

    private static void getlocal() {
                String url="https://apis.map.qq.com";
        String url2="/ws/location/v1/ip?ip=117.157.103.143&key=AHPBZ-WZLLJ-46MFZ-KKLQW-RHG4J-JRBLI";
        String s1 = new MD5().digestHex(url2+"yvcFoIg3ogcwpJxf0fp3WyxYo7GYuhq").toString();
        System.out.println(url+url2+"&sig="+s1);
        String s = HttpUtil.get(url+url2+"&sig="+s1);
        System.out.println(s);
    }
//    private static String getIpAddress(HttpServletRequest request) {
//        String ip = request.getHeader("x-forwarded-for");
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_CLIENT_IP");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//            if("127.0.0.1".equals(ip)||"0:0:0:0:0:0:0:1".equals(ip)){
//                //根据网卡取本机配置的IP
//                InetAddress inet=null;
//                try {
//                    inet = InetAddress.getLocalHost();
//                } catch (UnknownHostException e) {
//                    e.printStackTrace();
//                }
//                ip= inet.getHostAddress();
//            }
//        }
//        return ip;
//    }
}
