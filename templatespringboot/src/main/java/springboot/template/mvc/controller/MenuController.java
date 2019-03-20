package springboot.template.mvc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springboot.template.global.result.R;
import springboot.template.mvc.entity.SysPermission;
import springboot.template.mvc.service.SysPermissionService;

import javax.annotation.Resource;

/**
 * @Auther HUGH
 * @Date 2018/7/30
 * @Description MenuController
 */
@Controller
@RequestMapping(value = "/sys/menu/", method = RequestMethod.GET)
public class MenuController extends BaseController {
    @Resource
    private SysPermissionService sysPermissionService;

    @ModelAttribute
    public SysPermission get(String id) {
        SysPermission sysPermission = null;
        if (StringUtils.isNotEmpty(id)) {
            sysPermission = sysPermissionService.get(id);
        }
        return sysPermission;
    }

    @RequestMapping("list")
    @RequiresPermissions("sys:menu:list")
    public R list(SysPermission sysPermission) {
        PageInfo<SysPermission> list = sysPermissionService.list(sysPermission, new Page(1, 10));
        return R.ok().put("entity", sysPermission).put("list", list);
    }

    @RequestMapping("save")
    public R save(SysPermission sysPermission) {
        sysPermissionService.insert(sysPermission);
        return R.ok();
    }

    @RequestMapping("update")
    public R update(SysPermission sysPermission) {
        sysPermissionService.update(sysPermission);
        return R.ok();
    }
}
