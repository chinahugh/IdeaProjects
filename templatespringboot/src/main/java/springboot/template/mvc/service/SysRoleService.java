package springboot.template.mvc.service;

import springboot.template.mvc.entity.SysRole;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/30
 * @Description SysRoleService
 */
public interface SysRoleService {
    List<SysRole> getUserRoles(String userId);
}
