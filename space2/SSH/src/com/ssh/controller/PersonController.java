package com.ssh.controller;

import com.ssh.entity.Person;
import com.ssh.serviceimpl.PersonServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author: hugh
 * @Date: 17-11-24:下午9:01
 * @Description: 标识它是一个控制器
 */
@Controller
@SessionAttributes(value = "username")
@RequestMapping(value = "/ssh/person/")
public class PersonController {

    @Resource
    private PersonServiceImpl service;


    /**
     * 登录请求，失败返回error.jsp
     *
     * @param username username
     * @param password password
     * @param map map
     * @return String
     */
    @PostMapping("login")
    public String login(String username, String password, Map<String, Object> map) {
        if (username.equals("admin") & password.equals("123")) {
            map.put(username, password);//存放在request请求域中

            /*
              类上加上@SessionAttributes({"username"}) 同时也会存放在 session域中
              @SessionAttributes 除了可以通过属性名指定需要存放到会话中的属性外(使用的是value属性值)
             * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中(实际上使用的是types属性值),
             */
            return "frame";
        }
        return "error";
    }

    /**
     * 跳转到添加页面
     * savepage.jsp
     *
     * @return String
     */
    @RequestMapping(value = "addperson")
    public String saveperson() {

        return "savepage";
    }

    /**
     * 跳转到更新页面，回显数据
     * editpage.jsp
     *
     * @param id
     * @param model 使用的Model保存回显数据
     * @return String
     */
    @RequestMapping(value = "doupdate")
    public String doupdate(@RequestParam(value = "id") String id, Model model) {
        model.addAttribute("person", service.getPersonById(id));
        return "editpage";
    }

    /**
     * 删除一条数据
     *
     * @param id
     * @return String
     */

    @RequestMapping(value = "deletepersonById")
    public String deletePersonById(@RequestParam(value = "id") String id) {
        System.out.println("删除单个");
        service.deletePersonById(id);
        return "redirect:main";
    }

    /**
     * 更新数据
     *
     * @param person
     * @return String
     */
    @RequestMapping("updateperson")
    public String updatePerson(Person person) {
        service.updatePerson(person);
        return "redirect:main";
    }

    /**
     * 保存添加的数据
     *
     * @param person
     * @return String
     */
    @RequestMapping(value = "saveperson", method = RequestMethod.GET)
    public String savePerson(Person person) {
        service.addPerson(person);
        return "redirect:main";
    }

    /**
     * 查询所有人员信息
     *
     * @param map 使用的是map保存回显数据
     * @return String
     */
    @RequestMapping("main")
    public String main(Map<String, Object> map) {
        map.put("personlist", service.getPersons());
        /*遍历集合，查看查询到的数据
         * List<Person> lists = personService.getPersons();
		 * Iterator<Person> it = lists.iterator();
		 * while(it.hasNext()){
		 * 		Person p =it.next();
		 *	 	System.out.println(p.toString());
		 *  }
		 */
        return "main";
    }
}