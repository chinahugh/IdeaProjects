package springboot.template.mvc.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.template.mvc.entity.SysDepartment;
import springboot.template.mvc.entity.SysPermission;
import springboot.template.mvc.entity.SysRole;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysDepartmentMapperTest {
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;

    @Test
    public void get() {
        SysDepartment sysDepartment = sysDepartmentMapper.get("1");
        System.out.println("sysDepartment = " + sysDepartment);
    }

    @Test
    public void select() {
        SysDepartment sysDepartment = new SysDepartment();
        sysDepartment.setFatherId("0");
        System.out.println(" = " + sysDepartmentMapper.select(sysDepartment));
    }

    @Test
    public void deleteByKey() {
        SysDepartment sysDepartment = new SysDepartment();
        sysDepartment.setFatherId("0");
        System.out.println(" = " + sysDepartmentMapper.select(sysDepartment));
    }

    @Test
    public void insert() {
        SysDepartment sysDepartment = new SysDepartment();
        sysDepartment.setId("2");
        sysDepartment.setDepartmentName("asdasd");
        sysDepartment.setFatherId("0");
        System.out.println(" = " + sysDepartmentMapper.insert(sysDepartment));
    }

    @Test
    public void update() {
        SysDepartment sysDepartment = new SysDepartment();
        sysDepartment.setFatherId("0");
        System.out.println(" = " + sysDepartmentMapper.select(sysDepartment));
    }

    @Test
    public void list() {
        SysDepartment sysDepartment = new SysDepartment();
        sysDepartment.setFatherId("0");
        System.out.println(" = " + sysDepartmentMapper.list(sysDepartment));
    }
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysPermissionMapper sysPermissionMapper;
    @Test
    public void AA(){
//        List<SysRole> userRoles = sysRoleMapper.getUserRoles("1");
//        System.out.println("userRoles "+userRoles);
        List<SysPermission> userPermissions = sysPermissionMapper.getUserPermissions("1");
        System.out.println("userPermissions = " + userPermissions);
    }

}