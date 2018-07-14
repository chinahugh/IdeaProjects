package springboot.template.mvc.service;

import springboot.template.mvc.entity.SysPermission;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/7/14
 * @Description SysPermissionService
 */
public interface SysPermissionService {
    /**
     *
     * @param id
     * @return
     */
    List<SysPermission> getUserPermissions(String id);
}
