package springboot.template.mvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.template.global.exception.ServiceException;
import springboot.template.mvc.entity.SysDict;
import springboot.template.mvc.mapper.base.SysDictMapper;
import springboot.template.mvc.service.SysDictService;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/9/4
 * @Description SysDictServiceImpl
 */
@Service("sysDictService")
@Transactional(rollbackFor = ServiceException.class)
public class SysDictServiceImpl implements SysDictService {
    @Autowired
    private SysDictMapper sysDictMapper;

    /**
     * 查找一个实例
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = ServiceException.class, readOnly = true)
    public SysDict get(String id) {
        SysDict sysDict = sysDictMapper.get(id);
        return sysDict;
    }

    /**
     * 查找一个实例
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional(rollbackFor = ServiceException.class, readOnly = true)
    public SysDict select(SysDict entity) {
        return sysDictMapper.select(entity);
    }

    /**
     * 删除一个实例
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByKey(String id) {
        return sysDictMapper.deleteByKey(id);
    }

    /**
     * 插入一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public int insert(SysDict entity) {
        return sysDictMapper.insert(entity);
    }

    /**
     * 更新一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public int update(SysDict entity) {
        sysDictMapper.update(entity);
        return 0;
    }

    /**
     * 列表
     *
     * @param entity
     * @return
     */
    @Override
    public List<SysDict> list(SysDict entity) {
        List  list = sysDictMapper.list(entity);
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
    public PageInfo<SysDict> list(SysDict entity, Page<SysDict> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<SysDict> list = list(entity);
        if (list != null && list.size() > 0) {
            return new PageInfo<>(list);
        }
        return null;
    }
}
