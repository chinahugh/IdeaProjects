package springboot.template.mvc.service.serviceimpl;

import org.springframework.stereotype.Service;
import springboot.template.mvc.entity.SysDirectory;
import springboot.template.mvc.mapper.SysDirectoryMapper;
import springboot.template.mvc.service.SysDirectoryService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/30
 * @Description SysDirectoryServiceImpl
 */
@Service
public class SysDirectoryServiceImpl implements SysDirectoryService {
    @Resource
    private SysDirectoryMapper sysDirectoryMapper;
    @Override
    public List<SysDirectory> getUserDirectorys(String userId) {
        List<SysDirectory> list=sysDirectoryMapper.getUserDirectorys(userId);
        return list;
    }
}
