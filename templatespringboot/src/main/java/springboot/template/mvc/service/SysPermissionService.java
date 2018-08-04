package springboot.template.mvc.service;

import org.springframework.stereotype.Service;
import springboot.template.mvc.entity.SysPermission;
import springboot.template.mvc.mapper.SysPermissionMapper;
import springboot.template.mvc.service.base.BaseService;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/7/14
 * @Description SysPermissionService
 */
@Service
public class SysPermissionService extends BaseService<SysPermissionMapper,SysPermission>{
    /**
     *根据userId获取用户去重以后的权限列表
     * @param id
     * @return
     */
   public List<SysPermission> getUserPermissions(String id){
        return mapper.getUserPermissions(id);
    }
}
