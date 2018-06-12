package springboot.template.global.result;

/**
 * @Auther HUGH
 * @Date 2018/6/9
 * @Description RetResponse 将结果转化为封装后的结果
 */
public class RetResponse {
    private final static String SUCCESS = "success";

    public static <T> RetResult<T> makeRsp(RetCode code, String msg, T data) {
        return new RetResult<T>().setCode(code).setMsg(msg).setData(data);
    }

    public static <T> RetResult<T> makeOKRsp(T data) {
        return makeRsp(RetCode.SUCCESS, SUCCESS, data);
    }

    public static <T> RetResult<T> makeOKRsp() {
        return makeRsp(RetCode.SUCCESS, SUCCESS);
    }

    public static <T> RetResult<T> makeErrRsp(String message) {
        return makeRsp(RetCode.FAIL, message);
    }

    public static <T> RetResult<T> makeRsp(RetCode code, String msg) {
        return makeRsp(code, msg, null);
    }

}
