package springboot.template.mvc.entity.base;

import java.io.Serializable;

/**
 * @Auther HUGH
 * @Date 2018/7/1
 * @Description BaseEntity
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -7202325628651053055L;
    private Boolean isNew=false;
    private String id;

    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this.id = id;
    }

    public Boolean getNew() {
        return isNew||this.getId()==null;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
