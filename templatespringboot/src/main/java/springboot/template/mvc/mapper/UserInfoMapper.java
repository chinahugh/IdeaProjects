package springboot.template.mvc.mapper;

import org.apache.tomcat.jni.Directory;
import org.springframework.stereotype.Component;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.mapper.base.BaseMapper;

import java.util.List;

@Component
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    /**
     * 得到用户权限（目录）
     * @param userInfo
     * @return
     */
    List<Directory> getDirectoryList(UserInfo userInfo);


}