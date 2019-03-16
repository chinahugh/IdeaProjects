package springboot.template.mvc.service;

import springboot.template.mvc.entity.SysRole;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/30
 * @Description SysRoleService
 */
public interface SysRoleService extends BaseService<SysRole> {
    List<SysRole> getUserRoles(String userId);
}
