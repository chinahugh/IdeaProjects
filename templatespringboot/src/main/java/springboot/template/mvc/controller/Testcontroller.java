package springboot.template.mvc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.template.global.result.R;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.service.SysDepartmentService;
import springboot.template.mvc.service.UserInfoService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther HUGH
 * @Date 2018/6/14
 * @Description Testcontroller
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class Testcontroller {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private SysDepartmentService sysDepartmentService;
    @Value("${myconfig.id.type}")
    private String idType;

    @RequestMapping("list")
    @ResponseBody
    public PageInfo<UserInfo> list(UserInfo userInfo) {
//        System.out.println("JSONArray.fromObject(userInfo) = " + JSONArray.fromObject(userInfo));
        return userInfoService.list(userInfo, new Page());
    }

    @RequestMapping("find")
    @ResponseBody
    @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "query")})
    public R find(@RequestParam String id, Map map) {
        System.out.println(userInfoService.get(id));
        return R.ok().put("user", userInfoService.get(id));
    }


    @ResponseBody
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public UserInfo hello(String hello, HashMap<String, Object> map) {
        map.put("sysdepartment", hello);
        map.put("sysdepartment2", hello);
        UserInfo userInfo = userInfoService.get("1");
        map.put("user", userInfo);
        return userInfo;
    }

    @RequestMapping("insert")
    @ResponseBody
    public UserInfo insert() {
        System.out.println("idType = " + idType);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("sadas");
        userInfo.setRemarks("sadasdasd");
        userInfo.setUserPassword("sadasd");
        userInfo.setSex(2);
        userInfoService.insert(userInfo);
        return userInfo;
    }

    @RequestMapping("A")
    public String A() {
        return "test/A";
    }

    //    @RequestMapping("B")
//    public String B(){
//        return "test/B";
//    }
    @RequestMapping("main")
    public String main() {
        return "main";
    }
}
