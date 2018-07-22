package springboot.template.global.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import springboot.template.global.shiro.ShiroUser;

/**
 * @Auther HUGH
 * @Date 2018/7/16
 * @Description ShiroUtils shiro工具类
 */
public class ShiroUtils {
    /**
     * 得到shiro主体
     *
     * @return
     */
    public Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取shiroUser
     *
     * @return
     */
    public ShiroUser getShiroUser() {
        ShiroUser shiroUser = (ShiroUser) getSubject().getPrincipal();
        return shiroUser;
    }

    /**
     * 获取session
     * @return
     */
    public Session getSession() {
        Session session = getSubject().getSession();
        return session;
    }
}
