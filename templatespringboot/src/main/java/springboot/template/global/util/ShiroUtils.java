package springboot.template.global.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import springboot.template.mvc.entity.UserInfo;

/**
 * @Auther HUGH
 * @Date 2018/7/16
 * @Description ShiroUtil shiro工具类
 */
public class ShiroUtils {
    /**
     * 得到shiro主体
     *
     * @return
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取UserInfo
     *
     * @return
     */
    public static UserInfo getUserInfo() {
        UserInfo userInfo = (UserInfo) getSubject().getPrincipal();
        return userInfo;
    }

    /**
     * 获取session
     * @return
     */
    public static Session getSession() {
        Session session = getSubject().getSession();
        return session;
    }
}
