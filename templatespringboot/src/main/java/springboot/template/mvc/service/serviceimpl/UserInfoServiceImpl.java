package springboot.template.mvc.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.mapper.UserInfoMapper;
import springboot.template.mvc.service.UserInfoService;

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
    public PageInfo<UserInfo> listPageInfo(UserInfo userInfo) {
        PageHelper.startPage(1, 10);
        List<UserInfo> list = userInfoMapper.list(userInfo);
        return new PageInfo<>(list);
    }
}
