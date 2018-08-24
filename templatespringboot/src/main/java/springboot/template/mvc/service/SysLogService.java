package springboot.template.mvc.service;

import org.springframework.stereotype.Service;
import springboot.template.mvc.entity.SysLog;
import springboot.template.mvc.mapper.SysLogMapper;
import springboot.template.mvc.service.base.BaseService;

/**
 * @Auther HUGH
 * @Date 2018/8/4
 * @Description SysLogService
 */
@Service("sysLogService")
public class SysLogService extends BaseService<SysLogMapper,SysLog> {
}
