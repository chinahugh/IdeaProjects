package springboot.template.mvc.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.template.global.result.R;
import springboot.template.global.result.RR;
import springboot.template.global.util.ShiroUtil;
import springboot.template.mvc.entity.SysPermission;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.service.SysPermissionService;

import javax.annotation.Resource;
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
    @Resource
    private SysPermissionService sysPermissionService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public R login(@RequestParam(value = "userName", required = false) String userName,
                   @RequestParam(value = "userPassword", required = false) String userPassword) {
        System.out.println("getUserPassword " + userName + " getUserName " + userPassword);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, userPassword);
        try {
            subject.login(token);
        } catch (LockedAccountException e) {
            return RR.error("锁定的帐号");
        } catch (DisabledAccountException e) {
            return RR.error("禁用的帐号");
        } catch (UnknownAccountException e) {
            return RR.error("错误的帐号");
        } catch (ExcessiveAttemptsException e) {
            return RR.error("登录失败次数过多");
        } catch (IncorrectCredentialsException e) {
            return RR.error("错误的凭证");
        } catch (ExpiredCredentialsException e) {
            return RR.error("过期的凭证");
        } catch (Exception e) {
            return RR.error("登录失败");
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
        map.put("user", SecurityUtils.getSubject().getPrincipal());
        return RR.ok(map);
    }

    @RequestMapping(value = "index")
    @ResponseBody
    public R index() {
        Map<String,Object> map=new HashMap<>();
        UserInfo userInfo = ShiroUtil.getUserInfo();
        List<SysPermission> userPermissions = sysPermissionService.getUserPermissions(userInfo.getId());
        map.put("menu", userPermissions);
        return RR.ok(map);
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "redirect:login.html";
    }
}
