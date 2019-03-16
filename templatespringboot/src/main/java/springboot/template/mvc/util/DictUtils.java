package springboot.template.mvc.util;

import springboot.template.mvc.entity.SysDict;
import springboot.template.mvc.service.SysDictService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HUGH
 * @Date 2019/3/9 16:48
 * @Description DictUtils
 */
public class DictUtils {
    @Resource
    private static SysDictService sysDictService;
    public static final String MAIN_DAY_TAG = "main_day_tag";

    public  List<SysDict> getpTags(String tag) {
        SysDict sysDict = new SysDict();
        sysDict.setType(tag);
        List<SysDict> list = sysDictService.list(sysDict);
        return list;
    }
}
