package springboot.com.mvc.service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.com.mvc.entity.XmMainDay;
import springboot.com.mvc.mapper.XmMainDayMapper;
import springboot.com.mvc.service.XmMainDayService;
import springboot.com.mvc.service.XmMainMonthService;
import springboot.com.mvc.util.TimeTagUtils;
import springboot.template.global.exception.ServiceException;
import springboot.template.global.util.UUIDUtils;
import springboot.template.mvc.entity.SysDict;
import springboot.template.mvc.mapper.base.SysDictMapper;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/8/8
 * @Description XmMainDayServiceImpl
 */
@Service("xmMainDayService")
@Transactional(rollbackFor = ServiceException.class)
public class XmMainDayServiceImpl implements XmMainDayService {
    @Resource
    private XmMainDayMapper xmMainDayMapper;
    @Resource
    private XmMainMonthService xmMainMonthService;
    @Resource
    private SysDictMapper sysDictMapper;

    /**
     * 查找一个实例
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = ServiceException.class, readOnly = true)
    public XmMainDay get(String id) {
        return xmMainDayMapper.get(id);
    }

    /**
     * 查找一个实例
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional(rollbackFor = ServiceException.class, readOnly = true)
    public XmMainDay select(XmMainDay entity) {
        return xmMainDayMapper.select(entity);
    }

    /**
     * 删除一个实例
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public int deleteByKey(String id) {
        if (StringUtils.isBlank(id)) {
            return 0;
        }
        XmMainDay xmMainDay = xmMainDayMapper.get(id);
        //设置失效，不删除 TODO
        xmMainDay.setIsDisable(1);
        xmMainDayMapper.update(xmMainDay);
        xmMainMonthService.upMouth(xmMainDay.getMainMonthId());
        return 0;
    }

    /**
     * 插入一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public int insert(XmMainDay entity) {
        setTag(entity);
        //设置id
        entity.setId(UUIDUtils.getUUid());
        /*记录时间插入或更新*/
        entity.initDateEntity();
        int a = xmMainDayMapper.insert(entity);
        xmMainMonthService.upMouth(entity.getMainMonthId());
        return a;
    }

    /**
     * 更新一个实例
     *
     * @param entity
     * @return
     */
    @Override
    public int update(XmMainDay entity) {
//        setTag(entity);
        /*记录时间插入或更新*/
        entity.initDateEntity();
        int update = xmMainDayMapper.update(entity);
        xmMainMonthService.upMouth(entity.getMainMonthId());
        return update;
    }

    /**
     * 列表
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional(rollbackFor = ServiceException.class, readOnly = true)
    public List<XmMainDay> list(XmMainDay entity) {
        List<XmMainDay> list = xmMainDayMapper.list(entity);
        for (int i = 0; i < list.size(); i++) {
            XmMainDay x = list.get(i);
            String mTag = x.getmTag();
            String pTag = x.getpTag();
            x.setmTag(sysDictMapper.get(mTag).getLable());
            x.setpTag(sysDictMapper.get(pTag).getLable());
        }
        return xmMainDayMapper.list(entity);
    }

    /**
     * 列表
     *
     * @param entity
     * @return
     */
    @Override
    @Transactional(rollbackFor = ServiceException.class, readOnly = true)
    public PageInfo<XmMainDay> list(XmMainDay entity, Page<XmMainDay> page) {
        if (entity == null) {
            return null;
        }
        if (page == null) {
            page = new Page<>();
        }
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<XmMainDay> list = list(entity);
        if (list != null && list.size() > 0) {
            list.sort(Comparator.comparing(XmMainDay::getSysDay));
            return new PageInfo<>(list);
        }
        return null;
    }

    /**
     * 根据entity处理赋值相关属性
     *
     * @param entity
     */
    private void setTag(XmMainDay entity) {
        if (entity.getNewCreate()) {
            /*上班标志*/
            entity.setmTag(TimeTagUtils.getmTag(entity.getmData()));
            /*下班标志*/
            entity.setpTag(TimeTagUtils.getpTag(entity.getpData()));
        } else {
            SysDict sysDict = new SysDict();
            sysDict.setType("main_day_tag");
            List<SysDict> list = sysDictMapper.list(sysDict);
            for (SysDict d : list) {
                String lable = d.getLable();
                if (lable.equalsIgnoreCase(entity.getmData())) {
                    entity.setmTag(d.getValue());
                }
                if (lable.equalsIgnoreCase(entity.getpData())) {
                    entity.setpTag(d.getValue());
                }
            }
        }
    }
}
