package springboot.template.mvc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.template.global.result.R;
import springboot.template.global.result.RR;
import springboot.template.global.util.Md5Utils;
import springboot.template.global.util.ShiroUtils;
import springboot.template.mvc.entity.SysPermission;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.service.SysPermissionService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther HUGH
 * @Date 2018/6/9
 * @Description LoginController 用户登录
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.POST)
public class LoginController extends BaseController {
    @Autowired
    private SysPermissionService sysPermissionService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public R login(@RequestParam(value = "userName", required = false) String userName,
                   @RequestParam(value = "userPassword", required = false) String userPassword,
                   HttpServletResponse response) {
        System.out.println("getUserPassword " + userName + " getUserName " + userPassword);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, userPassword);
        try {
            subject.login(token);
        } catch (LockedAccountException e) {
            return RR.error("账号已被锁定,请联系管理员");
        } catch (DisabledAccountException e) {
            return RR.error("账号已被禁用,请联系管理员");
        } catch (UnknownAccountException e) {
            return RR.error("未找到该账户");
        } catch (ExcessiveAttemptsException e) {
            return RR.error("登录失败次数过多");
        } catch (IncorrectCredentialsException e) {
            return RR.error("错误的凭证");
        } catch (ExpiredCredentialsException e) {
            return RR.error("过期的凭证");
        } catch (Exception e) {
            return RR.error(e.getMessage());
        }
           /*
           * DisabledAccountException（禁用的帐号）
           * LockedAccountException（锁定的帐号）
           * UnknownAccountException（错误的帐号）
           * ExcessiveAttemptsException（登录失败次数过多）
           * IncorrectCredentialsException （错误的凭证）
           * ExpiredCredentialsException（过期的凭证）等
           * */
        HashMap<String, Object> map = new HashMap<>(1);
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        map.put("user", userInfo);
        Cookie name = new Cookie("name", Md5Utils.getMd5(userInfo.getName()));
        Cookie password = new Cookie("password", Md5Utils.getMd5(userInfo.getUserPassword()));
        response.addCookie(name);
        response.addCookie(password);
        return RR.ok(map);
    }

    @RequestMapping(value = "index", method = RequestMethod.POST)
    @ResponseBody
    public R index(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        UserInfo userInfo = ShiroUtils.getUserInfo();
        List<SysPermission> userPermissions = sysPermissionService.getUserPermissions(userInfo.getId());
        StringBuilder sb = new StringBuilder();
/*        for (SysPermission p : userPermissions) {
            if ("1".equals(p.getFatherId())) {
                System.out.println(p);
                List<SysPermission> chide = chide(p, userPermissions);
                System.out.println(chide.toString());
                String url = p.getUrl() == null ? "#" : p.getUrl();
                sb.append("<li class='list-group-item'><a href='").append(url).append("'>").append(p.getUrlName()).append("</a></li>");
                if (chide.size() > 0) {
                    for (SysPermission pp : chide) {
                        sb.append("<li class='list-group-item '><a href=").append(pp.getUrl()).append(">").append(pp.getUrlName()).append("</a></li>");
                    }
                }
            }
        }*/
        sb.append("<li class='list-group-item '><a href='/sys/dict/list'>字典列表</a></li>");
        sb.append("<li class='list-group-item '><a href='/pro/xmMain/list'>数据处理</a></li>");
        map.put("menu", sb.toString());
        map.put("list", userPermissions);
        return RR.ok(map);
    }

    /**
     * 查找节点的直接子节点
     *
     * @param p
     * @param userPermissions
     * @return
     */
    private List<SysPermission> chide(SysPermission p, List<SysPermission> userPermissions) {
        List<SysPermission> list = new ArrayList<>();
        if (p != null && p.getId() != null) {
            for (SysPermission m : userPermissions) {
                if (m != null && m.getFatherId() != null) {
                    if (m.getFatherId().equals(p.getId())) {
                        list.add(m);
                    }
                }
            }
        }
        return list;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:login.html";
    }
}
