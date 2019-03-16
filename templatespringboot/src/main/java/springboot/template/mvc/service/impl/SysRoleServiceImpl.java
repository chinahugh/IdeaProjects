package springboot.template.mvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.template.global.exception.ServiceException;
import springboot.template.mvc.entity.SysRole;
import springboot.template.mvc.mapper.base.SysRoleMapper;
import springboot.template.mvc.service.SysRoleService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/30
 * @Description sysRoleMapper
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> getUserRoles(String userId) {
        return sysRoleMapper.getUserRoles(userId);
    }

    /**
     * 查找一个实例
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = ServiceException.class, readOnly = true)
    public SysRole get(String id) {
        SysRole sysRole = sysRoleMapper.get(id);
        return sysRole;
    }

    /**
     * 查找一个实例
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional(rollbackFor = ServiceException.class, readOnly = true)
    public SysRole select(SysRole entity) {
        return sysRoleMapper.select(entity);
    }

    /**
     * 删除一个实例
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByKey(String id) {
        return sysRoleMapper.deleteByKey(id);
    }

    /**
     * 插入一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public int insert(SysRole entity) {
        return sysRoleMapper.insert(entity);
    }

    /**
     * 更新一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public int update(SysRole entity) {
        sysRoleMapper.update(entity);
        return 0;
    }

    /**
     * 列表
     *
     * @param entity
     * @return
     */
    @Override
    public List<SysRole> list(SysRole entity) {
        List list = sysRoleMapper.list(entity);
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
    public PageInfo<SysRole> list(SysRole entity, Page<SysRole> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<SysRole> list = list(entity);
        if (list != null && list.size() > 0) {
            return new PageInfo<>(list);
        }
        return null;
    }
}
