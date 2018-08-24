package springboot.template.mvc.service.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import springboot.template.global.exception.ServiceException;
import springboot.template.mvc.entity.base.BaseEntity;
import springboot.template.mvc.mapper.base.BaseMapper;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/7/29
 * @Description BaseService
 */
public class BaseService<D extends BaseMapper<E>, E extends BaseEntity> {
    @Autowired
    protected D mapper;

    public E get(String id) {
        E entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity=mapper.get(id);
        }
        return entity;
    }

    public E select(E entity) {
        if (entity == null) {
            return null;
        }
        return mapper.select(entity);
    }

    public int deleteByKey(String id) {
        if (id == null) {
            return 0;
        }
        return mapper.deleteByKey(id);
    }

    public int insert(E entity) {
        if (entity == null) {
            return 0;
        }
        return mapper.insert(entity);
    }
@Transactional(rollbackFor = ServiceException.class)
    public int update(E entity) {
        if (entity == null) {
            return 0;
        }
        return mapper.update(entity);
    }

    public List<E> list(E entity) {
        if (entity == null) {
            return null;
        }
        return mapper.list(entity);
    }

    public PageInfo<E> list(E entity, Page<E> page) {
        if (entity == null) {
            return null;
        }
        if (page == null) {
            page = new Page<>();
        }
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<E> list = list(entity);
        if (list != null && list.size() > 0) {
            return new PageInfo<>(list);
        }
        return null;
    }
}
