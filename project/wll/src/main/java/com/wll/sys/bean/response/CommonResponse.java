package com.wll.sys.bean.response;

/**
 * @Auther HUGH
 * @Date 2018/5/10
 * @Description CommonResponse
 */
public class CommonResponse {
    private int resCode;
    private String resMsg;

    public int getResCode() {
        return resCode;
    }

    public void setResCode(int resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }
}
