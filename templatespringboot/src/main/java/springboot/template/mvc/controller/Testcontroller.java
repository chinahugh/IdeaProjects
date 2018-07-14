package springboot.template.mvc.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.template.global.result.R;
import springboot.template.global.result.RR;
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
@RequestMapping(value = "/",method = RequestMethod.GET)
public class Testcontroller implements ViewPath {
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private SysDepartmentService sysDepartmentService;

    @RequestMapping("list")
    @ResponseBody
    public PageInfo<UserInfo> list(UserInfo userInfo) {
        System.out.println("JSONArray.fromObject(userInfo) = " + JSONArray.fromObject(userInfo));
        return userInfoService.list(userInfo);
    }

    @RequestMapping("find")
    @ResponseBody
    @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "query")})
    public R find(@RequestParam String id, Map map) {

        map.put("user",userInfoService.find(id));
        System.out.println(userInfoService.find(id));
        return RR.ok();
    }

    @RequestMapping("hello")
    @ResponseBody
    public R hello(String hello,  HashMap<String, Object> map){
        map.put("sysdepartment",hello);
        map.put("sysdepartment2",hello);
        UserInfo userInfo = userInfoService.find("1");
        map.put("user",userInfo);
        return RR.ok(map);
    }
    @RequestMapping("user")
    public String user(){
        return SYS_PATH+"user";
    }
}
