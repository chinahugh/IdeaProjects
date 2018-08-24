package springboot.com.mvc.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import springboot.template.mvc.entity.base.BaseEntity;

/**
 * @Auther HUGH
 * @Date 2018/8/8
 * @Description BaseService
 */
public interface BaseService<E extends BaseEntity> {
    /**
     * 查找一个实例
     *
     * @param id
     * @return
     */
    E get(String id);

    /**
     * 查找一个实例
     *
     * @param entity
     * @return
     */
    E select(E entity);

    /**
     * 删除一个实例
     *
     * @param id
     * @return
     */
    int deleteByKey(String id);
//    /**
//     * 删除
//     *
//     * @param entity
//     * @return
//     */
//    int delete(E entity);

    /**
     * 插入一个实例
     *
     * @param entity
     * @return
     */
    int insert(E entity);

    /**
     * 更新一个实例
     *
     * @param entity
     * @return
     */
    int update(E entity);

    /**
     * 列表
     *
     * @param entity
     * @return
     */
    PageInfo<E> list(E entity, Page<E> page);
}
