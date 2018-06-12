package springboot.template.mvc.service;


import com.github.pagehelper.PageInfo;
import springboot.template.mvc.entity.UserInfo;

/**
 * @Auther HUGH
 * @Date 2018/6/9
 * @Description UserInfoService
 */
public interface UserInfoService {

    PageInfo<UserInfo> list(UserInfo userInfo);

    UserInfo find(String id);

    UserInfo findOneUser(UserInfo userInfo);
}
