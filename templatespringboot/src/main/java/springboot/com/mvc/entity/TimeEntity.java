package springboot.com.mvc.entity;

import org.apache.commons.lang3.StringUtils;
import springboot.template.global.exception.ServiceException;

import java.io.Serializable;

/**
 * @Auther HUGH
 * @Date 2018/9/9
 * @Description TimeEntity
 */
public class TimeEntity implements Serializable {
    private static final long serialVersionUID = 3451083746626521190L;
    private String time;
    private Integer hour;
    private Integer minute;
    private Boolean is_cd;
    private Boolean is_zt;

    public TimeEntity(String time) {
        this.time = time;
        init();
    }

    private void init() {
        if (StringUtils.isBlank(time)){
            throw new ServiceException("time为空");
        }
    }
}
