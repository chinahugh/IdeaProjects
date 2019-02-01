package springboot.com.mvc.entity;

import springboot.template.mvc.entity.base.DateEntity;

/**
 * @author HUGH
 * @Date 2019/1/12 12:47
 * @Description ExcelEntity
 */
public class ExcelEntity extends DateEntity {
    private static final long serialVersionUID = -2105444202350031582L;
private String name;
private String noId;
private String departmentName;
private String[][] cqData;
    public ExcelEntity() {
        super();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoId() {
        return noId;
    }

    public void setNoId(String noId) {
        this.noId = noId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String[][] getCqData() {
        return cqData;
    }

    public void setCqData(String[][] cqData) {
        this.cqData = cqData;
    }
}
