package springboot.template.mvc.mapper;

import org.springframework.stereotype.Component;
import springboot.template.mvc.entity.SysDirectory;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.mapper.base.BaseMapper;

import java.util.List;

@Component
public interface SysDirectoryMapper extends BaseMapper<SysDirectory> {
    List<SysDirectory> getUserDirectory(UserInfo userInfo);

}