package springboot.template.mvc.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.template.mvc.entity.SysRole;
import springboot.template.mvc.service.SysRoleService;

import javax.annotation.Resource;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysRoleServiceImplTest {
    @Resource
    private SysRoleService sysRoleService;
    @Test
    public void getUserRoles() {
        List<SysRole> userRoles = sysRoleService.getUserRoles("1");
        System.out.println("****************************************");
        userRoles.forEach(System.out::println);
    }

    @Test
    public void get() {
    }

    @Test
    public void select() {
    }

    @Test
    public void deleteByKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }

    @Test
    public void list() {
    }

    @Test
    public void list1() {
    }
}