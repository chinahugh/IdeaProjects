package springboot.template.global.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import springboot.template.global.exception.ServiceException;
import springboot.template.global.util.ShiroUtils;
import springboot.template.mvc.entity.SysLog;
import springboot.template.mvc.service.SysLogService;

import javax.annotation.Resource;

/**
 * @Auther HUGH
 * @Date 2018/8/4
 * @Description SysLogAspect 保存日志
 */

public class SysLogAspect {
    private boolean is_savelog = true;
    @Resource
    private SysLogService sysLogService;

//    @Around("execution(* springboot.template.mvc..*(..))")
    public Object around(ProceedingJoinPoint point) {
        Object ret = null;
        if (is_savelog) {
            long start = System.currentTimeMillis();
            try {
                ret = point.proceed();
            } catch (Throwable throwable) {
                throw new ServiceException(throwable.getMessage(), throwable);
            }
            long time = System.currentTimeMillis() - start;
            saveLog(point, time);
        }
        return ret;
    }

    private void saveLog(ProceedingJoinPoint point, long time) {
        //类名
        String classname = point.getTarget().getClass().getName();
        //方法名
        String messedname = point.getSignature().getName();
        //参数
        String args = JSON.toJSONString(point.getArgs());
        //用户
        String username = ShiroUtils.getUserInfo().getUserName();
        SysLog sysLog = new SysLog();
        sysLog.setMethod(classname + messedname);
        sysLog.setUsername(username);
        sysLog.setParams(args);
        sysLog.setTime(time);
        sysLogService.insert(sysLog);
    }
}
