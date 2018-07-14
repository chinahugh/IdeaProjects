package springboot.template.mvc.entity.base;

import java.io.Serializable;

/**
 * @Auther HUGH
 * @Date 2018/7/1
 * @Description BaseEntity
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -7202325628651053055L;
    private Boolean isNewCreate=false;
    private String id;

    public BaseEntity() {
        super();
    }

    public BaseEntity(String id) {
        super();
        this.id = id;
    }

    public Boolean getNew() {
        return isNewCreate||this.getId()==null;
    }

    public void setNew(Boolean aNew) {
        isNewCreate = aNew;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
