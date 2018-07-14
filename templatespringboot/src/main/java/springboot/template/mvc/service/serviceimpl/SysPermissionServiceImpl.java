package springboot.template.mvc.service.serviceimpl;

import org.springframework.stereotype.Service;
import springboot.template.mvc.entity.SysPermission;
import springboot.template.mvc.mapper.SysPermissionMapper;
import springboot.template.mvc.service.SysPermissionService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/30
 * @Description SysDirectoryServiceImpl
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private SysPermissionMapper sysPermissionMapper;
    @Override
    public List<SysPermission> getUserPermissions(String userId) {
        List<SysPermission> list=sysPermissionMapper.getUserPermissions(userId);
        return list;
    }
}
