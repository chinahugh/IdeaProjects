package springboot.template.mvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import springboot.template.mvc.entity.SysLog;
import springboot.template.mvc.mapper.base.SysLogMapper;
import springboot.template.mvc.service.SysLogService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/8/4
 * @Description SysLogService
 */
@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;

    /**
     * 查找一个实例
     *
     * @param id
     * @return
     */
    @Override
    public SysLog get(String id) {
        return sysLogMapper.get(id);
    }

    /**
     * 查找一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public SysLog select(SysLog entity) {
        return sysLogMapper.select(entity);
    }

    /**
     * 删除一个实例
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByKey(String id) {
        return sysLogMapper.deleteByKey(id);
    }

    /**
     * 插入一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public int insert(SysLog entity) {
        return sysLogMapper.insert(entity);
    }

    /**
     * 更新一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public int update(SysLog entity) {
        return sysLogMapper.update(entity);
    }

    /**
     * 列表
     *
     * @param entity
     * @return
     */
    @Override
    public List<SysLog> list(SysLog entity) {
        return sysLogMapper.list(entity);
    }

    /**
     * 列表
     *
     * @param entity
     * @param page
     * @return
     */
    @Override
    public PageInfo<SysLog> list(SysLog entity, Page<SysLog> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<SysLog> list = list(entity);
        if (list != null && list.size() > 0) {
            return new PageInfo<>(list);
        }
        return null;
    }
}
