package springboot.template.mvc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import springboot.template.global.util.UUIDUtils;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.mapper.base.UserInfoMapper;
import springboot.template.mvc.service.UserInfoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/9
 * @Description UserInfoService
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 查找一个实例
     *
     * @param id
     * @return
     */
    @Override
    public UserInfo get(String id) {
        return userInfoMapper.get(id);
    }

    /**
     * 查找一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public UserInfo select(UserInfo entity) {
        return userInfoMapper.select(entity);
    }

    /**
     * 删除一个实例
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByKey(String id) {
        return userInfoMapper.deleteByKey(id);
    }

    /**
     * 插入一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public int insert(UserInfo entity) {
        entity.setId(UUIDUtils.getUUid());
        return userInfoMapper.insert(entity);
    }

    /**
     * 更新一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public int update(UserInfo entity) {
        return userInfoMapper.update(entity);
    }

    /**
     * 列表
     *
     * @param entity
     * @return
     */
    @Override
    public List<UserInfo> list(UserInfo entity) {
        return userInfoMapper.list(entity);
    }

    /**
     * 列表
     *
     * @param entity
     * @param page
     * @return
     */
    @Override
    public PageInfo<UserInfo> list(UserInfo entity, Page<UserInfo> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<UserInfo> list = list(entity);
        if (list != null && list.size() > 0) {
            return new PageInfo<>(list);
        }
        return null;
    }
}