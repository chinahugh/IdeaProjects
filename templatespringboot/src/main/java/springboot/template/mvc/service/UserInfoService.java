package springboot.template.mvc.service;

import org.springframework.stereotype.Service;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.mapper.UserInfoMapper;
import springboot.template.mvc.service.impl.BaseServiceImpl;

/**
 * @Auther HUGH
 * @Date 2018/6/9
 * @Description UserInfoService
 */
@Service("userInfoService")
public class UserInfoService extends BaseServiceImpl<UserInfoMapper,UserInfo> {

}