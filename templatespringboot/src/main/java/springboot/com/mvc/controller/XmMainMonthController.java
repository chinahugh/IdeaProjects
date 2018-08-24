package springboot.com.mvc.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springboot.com.mvc.entity.XmMainMonth;
import springboot.com.mvc.service.XmMainDayService;
import springboot.com.mvc.service.XmMainMonthService;
import springboot.template.global.result.R;
import springboot.template.global.result.RR;
import springboot.template.mvc.controller.BaseController;

/**
 * @Auther HUGH
 * @Date 2018/8/7
 * @Description XmMainMonthController
 */
@Controller
@RequestMapping(value = "/pro/xmMain/", method = RequestMethod.GET)
public class XmMainMonthController extends BaseController {
    @Autowired
    private XmMainMonthService xmMainMonthService;
    @Autowired
    private XmMainDayService xmMainDayService;

    @ModelAttribute
    public XmMainMonth get(String id) {
        XmMainMonth xmMainMonth = xmMainMonthService.get(id);
        if (xmMainMonth == null) {
            return new XmMainMonth();
        }
        return xmMainMonth;
    }
    @RequestMapping("get/{id}")
    public String get(@PathVariable("id")String id,Model model) {
        XmMainMonth xmMainMonth = xmMainMonthService.get(id);
        if (xmMainMonth == null) {
            return "/pro/xmMain/list";
        }
        model.addAttribute("entity",xmMainMonth);
        return "/pro/xmMain/update";
    }

    @RequestMapping("list")
    public String list(XmMainMonth xmMainMonth, Model model) {
        if (xmMainMonth == null) {
            xmMainMonth=new XmMainMonth();
        }
        PageInfo<XmMainMonth> list = xmMainMonthService.list(xmMainMonth, new Page<>());
        model.addAttribute("list", list);
        return "pro/xmMain/list";
    }

    @RequestMapping("update/{id}")
    public String update(@PathVariable("id")String id) {
        XmMainMonth xmMainMonth = null;
        if (StringUtils.isNotBlank(id)) {
             xmMainMonth = xmMainMonthService.get(id);
        }
        if (xmMainMonth == null) {
            return "pro/xmMain/list";
        }
        xmMainMonthService.update(xmMainMonth);
        return "pro/xmMain/list";
    }
    @RequestMapping("deleteByKey/{id}")
    public String deleteByKey(@PathVariable("id")String id) {
        if (StringUtils.isBlank(id)) {
            return "pro/xmMain/list";
        }
        xmMainMonthService.deleteByKey(id);
        return INDEX;
    }

    @RequestMapping("insert")
    public R insert(XmMainMonth xmMainMonth) {
        xmMainMonthService.insert(xmMainMonth);
        return RR.ok();
    }
}
