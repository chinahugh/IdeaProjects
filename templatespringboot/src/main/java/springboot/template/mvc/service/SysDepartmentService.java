package springboot.template.mvc.service;

import springboot.template.mvc.entity.SysDepartment;

/**
 * @Auther HUGH
 * @Date 2018/6/14
 * @Description SysDepartmentService
 */
public interface SysDepartmentService {
    SysDepartment find(String id);
}
