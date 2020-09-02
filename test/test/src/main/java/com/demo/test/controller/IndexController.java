package com.demo.test.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.demo.test.common.R;
import com.demo.test.entity.Menu;
import com.demo.test.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author HGH
 */
@RestController
public class IndexController {

    @Autowired
    private MenuServiceImpl menuService;

    @RequestMapping("/login")
    public R login(HttpServletRequest request, HttpServletResponse response, String name, String password) throws Exception {
        /*
         * 这里为了简单，就不验证用户名和密码的正确性了，实际验证跟其他的方式一样，
         *         就是比对一下输入的用户名密码跟数据的数据是否一样
         */
        System.out.println(name + ":" + password);
        String token;
        token = JWT.create()
                .withAudience(name)// 将 user id 保存到 token 里面
                .withExpiresAt(new Date(System.currentTimeMillis() + 20 * 60 * 1000))//定义token的有效期
                .sign(Algorithm.HMAC256("111"));// 加密秘钥，也可以使用用户保持在数据库中的密码字符串
        response.setHeader("token", token);
        return R.ok(token);
    }

    @RequestMapping("/info")
    public R queryPicea() {
        String ret = "通过验证";
        int a = 1 / 0;
        return R.ok(ret);
    }

    @RequestMapping("/menu")
    public R menu() {
        return R.ok(list());
    }

    public List<Menu> list() {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", 0) ;
        // 得到一级节点资源列表
        List<Menu> resources = menuService.list(wrapper);
        if (resources != null && resources.size() > 0) {
            resources.forEach(this::findAllChild);
        }
        return resources;
    }

    private void findAllChild(Menu resource) {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", resource.getId());//.eq("type",1) ;
        // 首次进入这个方法时，查出的是二级节点列表
        // 递归调用时，就能依次查出三、四、五等等级别的节点列表，
        // 递归能实现不同节点级别的无限调用,这个层次不易太深，否则有性能问题
        List<Menu> resources = menuService.list(wrapper);
        resource.setChild(resources);
        if (resources != null && resources.size() > 0) {
            resources.forEach(this::findAllChild);
        }
    }
}
