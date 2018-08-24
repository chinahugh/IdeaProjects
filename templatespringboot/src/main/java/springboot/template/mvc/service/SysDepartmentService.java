package springboot.template.mvc.service;

import org.springframework.stereotype.Service;
import springboot.template.mvc.entity.SysDepartment;
import springboot.template.mvc.mapper.SysDepartmentMapper;
import springboot.template.mvc.service.base.BaseService;

/**
 * @Auther HUGH
 * @Date 2018/6/14
 * @Description SysDepartmentService
 */
@Service("sysDepartmentService")
public class SysDepartmentService extends BaseService<SysDepartmentMapper,SysDepartment> {

}
