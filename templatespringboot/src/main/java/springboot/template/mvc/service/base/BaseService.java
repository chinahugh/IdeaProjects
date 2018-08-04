package springboot.template.mvc.service.base;

import springboot.template.mvc.mapper.base.BaseMapper;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/7/29
 * @Description BaseService
 */
public class BaseService<E> implements BaseMapper<E> {
    @Override
    public E get(String id) {
        return null;
    }

    @Override
    public E select(E entity) {
        return null;
    }

    @Override
    public int deleteByKey(String id) {
        return 0;
    }

    @Override
    public int insert(E entity) {
        return 0;
    }

    @Override
    public int update(E entity) {
        return 0;
    }

    @Override
    public List<E> list(E entity) {
        return null;
    }
}
