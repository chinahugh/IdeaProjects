package springboot.template.mvc.mapper;

import springboot.template.mvc.entity.SysPermission;
import springboot.template.mvc.mapper.base.BaseMapper;

import java.util.List;

public interface SysPermissionMapper extends BaseMapper<SysPermission>{
    List<SysPermission> getUserPermissions(String userId);
}