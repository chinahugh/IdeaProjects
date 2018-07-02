package springboot.template.mvc.service;

import springboot.template.mvc.entity.SysDirectory;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/30
 * @Description SysDirectoryService
 */
public interface SysDirectoryService {
    List<SysDirectory> getUserDirectorys(String userId);
}
