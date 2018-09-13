package springboot.template.mvc.service;

import org.springframework.stereotype.Service;
import springboot.template.mvc.entity.SysRole;
import springboot.template.mvc.mapper.SysRoleMapper;
import springboot.template.mvc.service.impl.BaseServiceImpl;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/30
 * @Description SysRoleService
 */
@Service("sysRoleService")
public class SysRoleService extends BaseServiceImpl<SysRoleMapper,SysRole> {
    public List<SysRole> getUserRoles(String userId){
        return mapper.getUserRoles(userId);
    }
}
