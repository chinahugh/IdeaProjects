package springboot.template.mvc.service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.template.global.util.ShiroUtil;
import springboot.template.global.util.UUIDUtil;
import springboot.template.mvc.entity.SysPermission;
import springboot.template.mvc.mapper.SysPermissionMapper;
import springboot.template.mvc.service.SysPermissionService;
import springboot.template.mvc.util.DateUtils;

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
    public SysPermission get(String id) {
        return sysPermissionMapper.get(id);
    }

    @Override
    public PageInfo<SysPermission> listPage(SysPermission sysPermission, Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<SysPermission> list = sysPermissionMapper.list(sysPermission);
        return new PageInfo<>(list);
    }

    @Override
    public List<SysPermission> getUserPermissions(String userId) {
        return sysPermissionMapper.getUserPermissions(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save(SysPermission sysPermission) {
        sysPermission.setId(UUIDUtil.getUUid());
        sysPermission.setCreateTime(DateUtils.getNowDate());
        sysPermission.setCreateUserId(ShiroUtil.getUserInfo().getId());
        return sysPermissionMapper.insert(sysPermission);
    }

    @Override
    public int update(SysPermission sysPermission) {
        return sysPermissionMapper.update(sysPermission);
    }
}
