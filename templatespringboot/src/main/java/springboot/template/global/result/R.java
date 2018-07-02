package springboot.template.global.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther HUGH
 * @Date 2018/6/9
 * @Description RetResult
 */

public class R  implements Serializable {
    private static final long serialVersionUID = -4306581789984092527L;
    private int code;
    private String msg;
    private Map<String,Object> data =new HashMap();

    public R() {
    }

    public R(RC code, String msg, Map<String, Object> data) {
        this.code = code.code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(RC code) {
        this.code = code.code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
