package springboot.template.mvc.service.serviceimpl;

import org.springframework.stereotype.Service;
import springboot.template.mvc.entity.SysRole;
import springboot.template.mvc.mapper.SysRoleMapper;
import springboot.template.mvc.service.SysRoleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/30
 * @Description SysRoleServiceImpl
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> getUserRoles(String userId) {
        List<SysRole> list = sysRoleMapper.getUserRoles(userId);
        return list;
    }
}
