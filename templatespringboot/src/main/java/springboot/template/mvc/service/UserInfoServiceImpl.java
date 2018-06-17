package springboot.template.mvc.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.mapper.UserInfoMapper;
import springboot.template.mvc.service.service.UserInfoService;

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
    public PageInfo<UserInfo> list(UserInfo userInfo) {
        PageHelper.startPage(1,10);
        List<UserInfo> list = userInfoMapper.list(userInfo);
        return new PageInfo<>(list);
    }


    @Override
    public UserInfo find(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserInfo findOneUser(UserInfo userInfo) {
        UserInfo retuser = null;
        List<UserInfo> list = userInfoMapper.list(userInfo);
        if (list == null) {
            return null;
        }
        if (list.size()>0) {
            retuser = list.get(0);
        }
        return retuser;
    }

    @Override
    public boolean login(UserInfo userInfo) {
        boolean isReturn=false;
        List<UserInfo> list = userInfoMapper.findUser(userInfo);
        if (list != null) {
            if (list.size()>0){
                isReturn=true;
            }
        }
        return isReturn;
    }
}
