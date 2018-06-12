package springboot.template.mvc.service;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/11
 * @Description UserRoleService
 */

public interface UserRoleService {
     List<String> getUserRoles(String userid);
}
