package springboot.template.mvc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springboot.template.mvc.entity.SysDict;
import springboot.template.mvc.service.SysDictService;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/9/5
 * @Description DictController
 */
@Controller
@RequestMapping(value = "/sys/dict/", method = RequestMethod.GET)
public class DictController extends BaseController {
    @Resource
    private SysDictService sysDictService;

    @RequestMapping("get/{id}")
    public String get(@PathVariable("id") String id, Model model) {
        SysDict entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sysDictService.get(id);
        }
        if (entity == null) {
            entity = new SysDict();
        }
        model.addAttribute("entity",entity);
        return "sys/dict/update";
    }
    @RequestMapping("list")
    public String list(SysDict sysDict, Model model) {
        List<SysDict> list = sysDictService.list(sysDict);
        list.sort(Comparator.comparing(SysDict::getSort));
        model.addAttribute("list",list);
        return "sys/dict/list";
    }
    @RequestMapping("update")
    public String update(SysDict sysDict, Model model) {
        int update = sysDictService.update(sysDict);
        return INDEX;
    }
    @RequestMapping("insert")
    public String insert(SysDict sysDict, Model model) {
        int update = sysDictService.insert(sysDict);
        return INDEX;
    }
    @RequestMapping("deleteByKey/{id}")
    public String deleteByKey(@PathVariable("id")String id) {
        int update = sysDictService.deleteByKey(id);
        return INDEX;
    }
}