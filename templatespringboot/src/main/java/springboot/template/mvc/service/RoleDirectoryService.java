package springboot.template.mvc.service;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/11
 * @Description RoleDirectoryService
 */
public interface RoleDirectoryService {
     List<String> getUserDirectorys(String userid);
}
