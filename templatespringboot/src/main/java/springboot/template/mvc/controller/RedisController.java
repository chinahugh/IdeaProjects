package springboot.template.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springboot.template.global.result.RetResponse;
import springboot.template.global.result.RetResult;
import springboot.template.mvc.service.RedisService;

import javax.annotation.Resource;

/**
 * @Auther HUGH
 * @Date 2018/6/10
 * @Description RedisController
 */
@Controller
@RequestMapping(value = "/redis/", method = RequestMethod.GET)
public class RedisController {
    @Resource
    private RedisService redisService;

    @RequestMapping("setReids")
    public RetResult<String> setRedis(String name) {
        redisService.set("name", name);
        return RetResponse.makeOKRsp(name);
    }

    @PostMapping("/getRedis")
    public RetResult<String> getRedis() {
        String name = redisService.get("name");
        return RetResponse.makeOKRsp(name);
    }
}
