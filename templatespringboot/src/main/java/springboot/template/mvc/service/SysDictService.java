package springboot.template.mvc.service;

import org.springframework.stereotype.Service;
import springboot.template.mvc.entity.SysDict;
import springboot.template.mvc.mapper.SysDictMapper;
import springboot.template.mvc.service.impl.BaseServiceImpl;

/**
 * @Auther HUGH
 * @Date 2018/8/4
 * @Description SysLogService
 */
@Service
public class SysDictService extends BaseServiceImpl<SysDictMapper,SysDict> {
}
