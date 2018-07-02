package springboot.template.mvc.mapper;

import springboot.template.mvc.entity.SysRole;
import springboot.template.mvc.mapper.base.BaseMapper;

import java.util.List;

public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> getUserRoles(String userId);
}