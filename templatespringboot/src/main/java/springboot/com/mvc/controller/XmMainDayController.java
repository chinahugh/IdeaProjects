package springboot.com.mvc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springboot.com.mvc.entity.XmMainDay;
import springboot.com.mvc.entity.XmMainMonth;
import springboot.com.mvc.service.XmMainDayService;
import springboot.com.mvc.service.XmMainMonthService;
import springboot.template.global.result.R;
import springboot.template.mvc.controller.BaseController;
import springboot.template.mvc.entity.SysDict;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.service.SysDictService;
import springboot.template.mvc.service.UserInfoService;

import javax.annotation.Resource;
import java.util.List;
//import net.sf.json.JSONArray;

/**
 * @Auther HUGH
 * @Date 2018/8/8
 * @Description XmMainDayController
 */
@Controller
@RequestMapping(value = "/pro/xmDay/", method = RequestMethod.GET)
public class XmMainDayController extends BaseController {
    @Resource
    private XmMainDayService xmMainDayService;
    @Resource
    private XmMainMonthService xmMainMonthService;
    @Resource
    private UserInfoService userInfoService;
    @Resource
    private SysDictService sysDictService;
    public static final String MAIN_DAY_TAG = "main_day_tag";

    @ModelAttribute
    public XmMainDay get(String id) {
        XmMainDay xmMainDay = xmMainDayService.get(id);
        if (xmMainDay == null) {
            xmMainDay = new XmMainDay();
        }
        return xmMainDay;
    }

    @RequestMapping("get/{id}")
    public String get(@PathVariable("id") String id, Model model) {
        logger.info("id =>" + id);
        XmMainDay xmMainDay = xmMainDayService.get(id);
        if (xmMainDay == null) {
            return INDEX;
        }
        SysDict sysDict = new SysDict();
        sysDict.setType(MAIN_DAY_TAG);
        List<SysDict> tagList = sysDictService.list(sysDict);
        model.addAttribute("entity", xmMainDay);
        model.addAttribute("userName", "wll");
        model.addAttribute("tagList", tagList);
        logger.info("tagList.size() ==" + tagList.size());
        return "pro/xmDay/update";
    }

    @RequestMapping("update")
    public String update(XmMainDay xmMainDay) {
        xmMainDayService.update(xmMainDay);
        return INDEX;
    }

    @RequestMapping("insert")
    public R insert(XmMainDay xmMainDay) {
        xmMainDayService.insert(xmMainDay);
        return R.ok();
    }

    @RequestMapping("deleteByKey/{id}")
    public String deleteByKey(@PathVariable("id") String id) {
        if (StringUtils.isBlank(id)) {
            return INDEX;
        }
        xmMainDayService.deleteByKey(id);
        return INDEX;
    }

    @RequestMapping("list")
    public String list(XmMainDay xmMainDay, Model model) {
        if (xmMainDay == null) {
            return INDEX;
        }
        XmMainMonth xmMainMonth = xmMainMonthService.get(xmMainDay.getMainMonthId());
        String userId = xmMainMonth.getUserId();
        UserInfo userInfo = userInfoService.get(userId);
        String name = userInfo.getName();
        PageInfo<XmMainDay> list = xmMainDayService.list(xmMainDay, new Page<>());
        if (list == null) {
            return INDEX;
        }
        model.addAttribute("page", list);
        model.addAttribute("userName", name);
        return "pro/xmDay/list";
    }
}
