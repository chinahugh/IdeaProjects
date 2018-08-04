package springboot.template.mvc.service.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import springboot.template.global.util.UUIDUtils;
import springboot.template.mvc.entity.base.BaseEntity;
import springboot.template.mvc.mapper.base.BaseMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/7/29
 * @Description BaseService
 */
public class BaseService<D extends BaseMapper<E>, E extends BaseEntity> {
    @Resource
    protected D mapper;

    /**
     * 查找一个实例
     *
     * @param id
     * @return
     */
    public E get(String id) {
        if (StringUtils.isBlank(id)) {
            return null;
        }
        return mapper.get(id);
    }

    /**
     * 查找一个实例
     *
     * @param entity
     * @return
     */
    public E select(E entity) {
        return mapper.select(entity);
    }

    /**
     * 删除一个实例
     *
     * @param id
     * @return
     */
    public int deleteByKey(String id) {
        return mapper.deleteByKey(id);
    }
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
    public int insert(E entity) {
        entity.setId(UUIDUtils.getUUid());
        return mapper.insert(entity);
    }

    /**
     * 更新一个实例
     *
     * @param entity
     * @return
     */
    public int update(E entity) {
        return mapper.update(entity);
    }

    /**
     * 列表
     *
     * @param entity
     * @return
     */
    public PageInfo<E> list(E entity, Page<E> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<E> list = mapper.list(entity);
        return new PageInfo<>(list);
    }
}
