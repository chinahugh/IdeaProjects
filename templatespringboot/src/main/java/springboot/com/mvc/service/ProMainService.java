package springboot.com.mvc.service;

import org.springframework.stereotype.Service;
import springboot.com.mvc.entity.ProMain;
import springboot.com.mvc.mapper.ProMainMapper;
import springboot.template.mvc.service.base.BaseService;

/**
 * @Auther HUGH
 * @Date 2018/8/4
 * @Description ProMainService
 */
@Service
public class ProMainService extends BaseService<ProMainMapper,ProMain> {
}
