package springboot.template.mvc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.template.global.result.R;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.service.UserInfoService;

import javax.annotation.Resource;

/**
 * @Auther HUGH
 * @Date 2018/7/31
 * @Description UserInfoController
 */
@Controller
@ResponseBody
@RequestMapping(value = "/sys/userinfo/", method = RequestMethod.POST)
public class UserInfoController extends BaseController {
    @Resource
    private UserInfoService userInfoService;

    @ModelAttribute
    public UserInfo get(String id) {
        UserInfo userInfo = null;
        if (StringUtils.isNotEmpty(id)) {
            userInfo = userInfoService.get(id);
        }
        if (userInfo == null) {
            userInfo = new UserInfo();
        }
        return userInfo;
    }

    @RequestMapping("list")
    public R list(UserInfo userInfo) {
        PageInfo<UserInfo> list = userInfoService.list(userInfo, new Page(1, 10));
        return R.ok().put("page", list).put("entity", userInfo);
    }

    @RequestMapping("save")
    public R save(UserInfo userInfo) {
        userInfoService.insert(userInfo);
        return R.ok();
    }

    @RequestMapping("update")
    public R update(UserInfo userInfo) {
        userInfoService.update(userInfo);
        return R.ok();
    }
}
