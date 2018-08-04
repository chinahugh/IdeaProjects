package springboot.template.mvc.service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.template.global.util.UUIDUtil;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.mapper.UserInfoMapper;
import springboot.template.mvc.service.UserInfoService;
import springboot.template.mvc.util.DateUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/9
 * @Description UserInfoServiceImpl
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo get(String id) {
        return userInfoMapper.get(id);
    }

    @Override
    public UserInfo select(UserInfo userInfo) {
        return userInfoMapper.select(userInfo);
    }

    @Override
    public PageInfo<UserInfo> listPageInfo(UserInfo userInfo,Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<UserInfo> list = userInfoMapper.list(userInfo);
        return new PageInfo<>(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(UserInfo userInfo) {
        userInfo.setId(UUIDUtil.getUUid());
        userInfo.setCreateTime(DateUtils.getNowDate());
        return userInfoMapper.insert(userInfo);
    }
    @Override
    public int update(UserInfo userInfo) {
        userInfo.setCreateTime(DateUtils.getNowDate());
        return userInfoMapper.update(userInfo);
    }
}
