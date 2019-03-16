package springboot.template.mvc.mapper.base;

import springboot.template.mvc.entity.SysRole;
import springboot.template.mvc.mapper.BaseMapper;

import java.util.List;

public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> getUserRoles(String userId);
}