package springboot.template.mvc.mapper;

import org.springframework.stereotype.Repository;
import springboot.template.mvc.entity.SysRole;
import springboot.template.mvc.mapper.base.BaseMapper;

import java.util.List;
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> getUserRoles(String userId);
}