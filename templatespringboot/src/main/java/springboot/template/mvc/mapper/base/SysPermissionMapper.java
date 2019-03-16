package springboot.template.mvc.mapper.base;

import springboot.template.mvc.entity.SysPermission;
import springboot.template.mvc.mapper.BaseMapper;

import java.util.List;

public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    List<SysPermission> getUserPermissions(String userId);
}