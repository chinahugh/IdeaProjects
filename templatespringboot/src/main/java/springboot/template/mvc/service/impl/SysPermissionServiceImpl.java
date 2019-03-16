package springboot.template.mvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.template.global.exception.ServiceException;
import springboot.template.mvc.entity.SysPermission;
import springboot.template.mvc.mapper.base.SysPermissionMapper;
import springboot.template.mvc.service.SysPermissionService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/7/14
 * @Description SysPermissionService
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private SysPermissionMapper sysPermissionMapper;
    /**
     *根据userId获取用户去重以后的权限列表
     * @param id
     * @return
     */
   @Override
   public List<SysPermission> getUserPermissions(String id){
        return sysPermissionMapper.getUserPermissions(id);
    }
    /**
     * 查找一个实例
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = ServiceException.class, readOnly = true)
    public SysPermission get(String id) {
        SysPermission sysPermission = sysPermissionMapper.get(id);
        return sysPermission;
    }

    /**
     * 查找一个实例
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional(rollbackFor = ServiceException.class, readOnly = true)
    public SysPermission select(SysPermission entity) {
        return sysPermissionMapper.select(entity);
    }

    /**
     * 删除一个实例
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByKey(String id) {
        return sysPermissionMapper.deleteByKey(id);
    }

    /**
     * 插入一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public int insert(SysPermission entity) {
        return sysPermissionMapper.insert(entity);
    }

    /**
     * 更新一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public int update(SysPermission entity) {
        sysPermissionMapper.update(entity);
        return 0;
    }

    /**
     * 列表
     *
     * @param entity
     * @return
     */
    @Override
    public List<SysPermission> list(SysPermission entity) {
        List  list = sysPermissionMapper.list(entity);
        return list;
    }

    /**
     * 列表
     *
     * @param entity
     * @param page
     * @return
     */
    @Override
    @Transactional(rollbackFor = ServiceException.class, readOnly = true)
    public PageInfo<SysPermission> list(SysPermission entity, Page<SysPermission> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<SysPermission> list = list(entity);
        if (list != null && list.size() > 0) {
            return new PageInfo<>(list);
        }
        return null;
    }
}
