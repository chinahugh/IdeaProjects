package springboot.template.mvc.mapper;

import org.apache.ibatis.annotations.Mapper;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.mapper.base.BaseMapper;

import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo>{
    List<UserInfo> findUser(UserInfo userInfo);
}