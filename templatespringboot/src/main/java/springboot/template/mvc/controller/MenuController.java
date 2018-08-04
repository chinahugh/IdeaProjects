package springboot.template.mvc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot.template.global.result.R;
import springboot.template.global.result.RH;
import springboot.template.global.result.RR;
import springboot.template.mvc.entity.SysPermission;
import springboot.template.mvc.service.SysPermissionService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Auther HUGH
 * @Date 2018/7/30
 * @Description MenuController
 */
@Controller
@ResponseBody
@RequestMapping(value = "/sys/menu/", method = RequestMethod.POST)
public class MenuController extends BaseController{
    @Resource
    private SysPermissionService sysPermissionService;

    @ModelAttribute
    public SysPermission get(String id) {
        SysPermission sysPermission = null;
        if (StringUtils.isNotEmpty(id)) {
            sysPermission = sysPermissionService.get(id);
        }
        if (sysPermission == null) {
            sysPermission = new SysPermission();
        }
        return sysPermission;
    }

    @RequestMapping("list")
    @RequiresPermissions("sys:menu:list")
    public RH list(SysPermission sysPermission) {
        Map<String, Object> map = RR.getMap();
        map.put("entity", sysPermission);
        PageInfo<SysPermission> list = sysPermissionService.listPage(sysPermission, new Page(1,10));
        map.put("list", list);
        return RH.ok(map);
    }

    @RequestMapping("save")
    @ResponseBody
    public R save(SysPermission sysPermission){
        sysPermissionService.save(sysPermission);
        return RR.ok();
    }
    @RequestMapping("update")
    @ResponseBody
    public R update(SysPermission sysPermission){
        sysPermissionService.save(sysPermission);
        return RR.ok();
    }
}
