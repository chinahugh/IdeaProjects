package springboot.template.mvc.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.template.mvc.entity.UserInfo;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoMapperTest {
    @Autowired
    private UserInfoMapper userInfoMappr;
    @Test
    public void  setUserInfoMappr(){
        System.out.println("userInfoMappr ="+userInfoMappr);
    }

    @Test
    public void get() {
        System.out.println("userInfoMappr.get(\"1\") = " + userInfoMappr.get("1"));
    }

@Test
    public void select() {
    UserInfo userInfo = new UserInfo();
    userInfo.setUserName("admin");
    UserInfo select = userInfoMappr.select(userInfo);
    System.out.println("select = " + select);
}

    @Test
    public void deleteByKey() {
        int i = userInfoMappr.deleteByKey("4");
        System.out.println("i = " + i);
    }




    @Test
    public void insert() {
        UserInfo userInfo = new UserInfo("4");
        userInfo.setUserName("asdf");
        userInfo.setUserPassword("sdds");
        int insert = userInfoMappr.insert(userInfo);
        System.out.println("insert = " + insert);
    }

    @Test
    public void update() {
        UserInfo userInfo = new UserInfo("4");
        userInfo.setUserName("asweqwedf");
        userInfo.setUserPassword("sdds萨克今年的快乐");
        int insert = userInfoMappr.update(userInfo);
        System.out.println("insert = " + insert);
    }

    @Test
    public void list() {
        UserInfo userInfo = new UserInfo();
userInfo.setUserName("dmin");
        List select = userInfoMappr.list(userInfo);
        System.out.println("select = " + select);
    }
}