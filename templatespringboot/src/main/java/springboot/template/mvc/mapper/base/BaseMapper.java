package springboot.template.mvc.mapper.base;

import springboot.template.mvc.entity.base.BaseEntity;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/10
 * @Description BaseMapper
 */
public interface BaseMapper<E extends BaseEntity> {
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
    List<E> list(E entity);
}
