package springboot.template.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.template.global.result.R;
import springboot.template.global.result.RR;
import springboot.template.mvc.service.RedisService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Auther HUGH
 * @Date 2018/6/10
 * @Description RedisController
 */
@Controller
@ResponseBody
@RequestMapping(value = "/sys/redis/", method = RequestMethod.GET)
public class RedisController {
    @Resource
    private RedisService redisService;

    @RequestMapping("setReids")
    public R setRedis(String name, Map<String,Object> map) {
        redisService.set("name", name);
        return RR.ok();
    }

    @PostMapping("/getRedis")
    public R getRedis(Map<String,Object> map) {
        String name = redisService.get("name");
        map.put(name,name);
        return RR.ok();
    }
}
