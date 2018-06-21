package springboot.template.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.template.mvc.entity.SysDepartment;
import springboot.template.mvc.mapper.SysDepartmentMapper;
import springboot.template.mvc.service.service.SysDepartmentService;

import javax.annotation.Resource;

/**
 * @Auther HUGH
 * @Date 2018/6/14
 * @Description SysDepartmentServiceImpl
 */
@Service
public class SysDepartmentServiceImpl implements SysDepartmentService {
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;
    @Override
    public SysDepartment find(String id) {
        return sysDepartmentMapper.selectByPrimaryKey(id);
    }
}