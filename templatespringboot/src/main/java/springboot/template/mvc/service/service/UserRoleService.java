package springboot.template.mvc.service.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/11
 * @Description UserRoleService
 */
@Service
public interface UserRoleService {
     List<String> getUserRoles(String userid);
}
