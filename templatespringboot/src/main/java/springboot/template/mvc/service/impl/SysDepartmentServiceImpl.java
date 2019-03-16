package springboot.template.mvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import springboot.template.mvc.entity.SysDepartment;
import springboot.template.mvc.mapper.base.SysDepartmentMapper;
import springboot.template.mvc.service.SysDepartmentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/14
 * @Description SysDepartmentService
 */
@Service("sysDepartmentService")
public class SysDepartmentServiceImpl implements SysDepartmentService {
    
    @Resource
    private SysDepartmentMapper sysDepartmentMapper;

    /**
     * 查找一个实例
     *
     * @param id
     * @return
     */
    @Override
    public SysDepartment get(String id) {
        return sysDepartmentMapper.get(id);
    }

    /**
     * 查找一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public SysDepartment select(SysDepartment entity) {
        return sysDepartmentMapper.select(entity);
    }

    /**
     * 删除一个实例
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByKey(String id) {
        return sysDepartmentMapper.deleteByKey(id);
    }

    /**
     * 插入一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public int insert(SysDepartment entity) {
        return sysDepartmentMapper.insert(entity);
    }

    /**
     * 更新一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public int update(SysDepartment entity) {
        return sysDepartmentMapper.update(entity);
    }

    /**
     * 列表
     *
     * @param entity
     * @return
     */
    @Override
    public List<SysDepartment> list(SysDepartment entity) {
        return sysDepartmentMapper.list(entity);
    }

    /**
     * 列表
     *
     * @param entity
     * @param page
     * @return
     */
    @Override
    public PageInfo<SysDepartment> list(SysDepartment entity, Page<SysDepartment> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<SysDepartment> list = list(entity);
        if (list != null && list.size() > 0) {
            return new PageInfo<>(list);
        }
        return null;
    }
}
