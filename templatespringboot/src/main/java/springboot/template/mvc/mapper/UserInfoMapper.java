package springboot.template.mvc.mapper;

import org.springframework.stereotype.Repository;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.mapper.base.BaseMapper;
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}