package springboot.template.mvc.mapper;

import org.apache.ibatis.annotations.Mapper;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.mapper.base.BaseMapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo>{
    UserInfo findUser(UserInfo userInfo);

    UserInfo login(UserInfo userInfo);
}