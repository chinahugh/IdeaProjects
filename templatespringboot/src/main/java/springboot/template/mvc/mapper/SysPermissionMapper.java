package springboot.template.mvc.mapper;

import org.springframework.stereotype.Repository;
import springboot.template.mvc.entity.SysPermission;
import springboot.template.mvc.mapper.base.BaseMapper;

import java.util.List;
@Repository
public interface SysPermissionMapper extends BaseMapper<SysPermission>{
    List<SysPermission> getUserPermissions(String userId);
}