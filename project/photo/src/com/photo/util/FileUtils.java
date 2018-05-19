package com.photo.util;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.api.rs.RSClient;
import org.json.JSONException;

import java.io.*;

/**
 * @Auther HUGH
 * @Date 2018/3/18
 * @Description FileUtil
 */
public class FileUtils {
    private static final String ACCESS_KEY="5VsKzc5TUDPjZ0egfl0bulh5ChXNWt5DPMrUdvJa";//秘钥
    private static final String SECRET_KEY="jLYMKRbAQe1rPDAThNhHtD4BzJlpGNNm8BJppegm";
    private static final String BUCKE_NAME="huguohui1314";//名字

    /**
     *  上传图片到七牛云存储
     * @param reader
     * @param fileName
     */
    public static PutRet upload(InputStream reader,String fileName){
        String uptoken;
        PutRet putRet = null;
        try{
            Mac mac=new Mac(ACCESS_KEY,SECRET_KEY);
            System.out.println(mac);
            PutPolicy putPolicy = new PutPolicy(BUCKE_NAME);
            System.out.println(putPolicy.toString());
            uptoken = putPolicy.token(mac);
             putRet=IoApi.Put(uptoken,fileName,reader,null);
        }catch (AuthException | JSONException e){
            e.printStackTrace();
        }
        return putRet;
    }

    /**
     * 删除七牛云存储的照片
     * @param key
     */
    public static void delete(String key){
        Mac mac = new Mac(ACCESS_KEY, SECRET_KEY);
        RSClient rsClient = new RSClient(mac);
        rsClient.delete(BUCKE_NAME,key);
    }

    public static void main(String[] args) {
        try {
            FileInputStream fileReader = new FileInputStream(new File("E:/图片/121049351_1536_864.jpg"));
            PutRet upload = upload(fileReader, "kk.jpg");
            System.out.println(upload);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
