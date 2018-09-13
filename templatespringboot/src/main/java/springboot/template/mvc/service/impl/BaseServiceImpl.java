package springboot.template.mvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import springboot.template.global.exception.ServiceException;
import springboot.template.global.util.UUIDUtils;
import springboot.template.mvc.entity.base.DateEntity;
import springboot.template.mvc.mapper.base.BaseMapper;
import springboot.template.mvc.service.BaseService;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/7/29
 * @Description BaseService
 */
public class BaseServiceImpl<D extends BaseMapper<E>, E extends DateEntity> implements BaseService<E> {
    @Autowired
    protected D mapper;

    @Override
    public E get(String id) {
        E entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = mapper.get(id);
        }
        return entity;
    }

    @Override
    public E select(E entity) {
        if (entity == null) {
            return null;
        }
        return mapper.select(entity);
    }

    @Override
    public int deleteByKey(String id) {
        if (id == null) {
            return 0;
        }
        E e = mapper.get(id);
        if (e == null) {
            return 0;
        }
        e.setIsDisable(1);
        e.initDateEntity();
        return mapper.update(e);
    }

    @Override
    public int insert(E entity) {
        if (entity == null) {
            return 0;
        }
        if (entity.getNewCreate()) {
            entity.setId(UUIDUtils.getUUid());
            entity.initDateEntity();
        }
        return mapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public int update(E entity) {
        if (entity == null) {
            return 0;
        }
        entity.initDateEntity();
        return mapper.update(entity);
    }

    @Override
    public List<E> list(E entity) {
        if (entity == null) {
            return null;
        }
        return mapper.list(entity);
    }

    @Override
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
