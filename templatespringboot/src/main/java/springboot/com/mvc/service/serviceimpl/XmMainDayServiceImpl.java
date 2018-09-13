package springboot.com.mvc.service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import springboot.template.mvc.service.SysDictService;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/8/8
 * @Description XmMainDayServiceImpl
 */
@Service
@Transactional(rollbackFor = ServiceException.class)
public class XmMainDayServiceImpl implements XmMainDayService {
    @Resource
    private XmMainDayMapper xmMainDayMapper;
    @Resource
    private XmMainMonthService xmMainMonthService;
    @Autowired
    private SysDictService sysDictService;

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
        upMouth(xmMainDay);
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
        //设置id
        entity.setId(UUIDUtils.getUUid());
        setTag(entity);
         /*记录时间插入或更新*/
        entity.initDateEntity();
        int a = xmMainDayMapper.insert(entity);
        upMouth(entity);
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
        setTag(entity);
         /*记录时间插入或更新*/
        entity.initDateEntity();
        int update = xmMainDayMapper.update(entity);
        upMouth(entity);
        return update;
    }

    /**
     * 列表
     *
     * @param entity
     * @return
     */
    @Override
    public List<XmMainDay> list(XmMainDay entity) {
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
        List<XmMainDay> list = xmMainDayMapper.list(entity);
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
            List<SysDict> list = sysDictService.list(sysDict);
            for (SysDict d : list) {
                String lable = d.getLable();
                if (lable.equalsIgnoreCase(entity.getmData()))
                {
                    entity.setmTag(Integer.parseInt(d.getValue()));
                }
                if (lable.equalsIgnoreCase(entity.getpData()))
                {
                    entity.setpTag(Integer.parseInt(d.getValue()));
                }
            }
        }
    }

    /**
     * 根据entity计算XmMainMonth的变化
     *
     * @param entity
     */
    private void upMouth(XmMainDay entity) {
        XmMainDay xmMainDay = new XmMainDay();
       if (StringUtils.isBlank(entity.getMainMonthId())) {
            throw new ServiceException("XmMainDay中mainMonthId为NULL");
        }
        xmMainDay.setMainMonthId(entity.getMainMonthId());
        xmMainDay.setIsDisable(0);
        List<XmMainDay> list = xmMainDayMapper.list(xmMainDay);
        SysDict sysDict = new SysDict();
        sysDict.setType("main_day_tag");
        List<SysDict> dicts = sysDictService.list(sysDict);
        dicts.sort(Comparator.comparing(o -> new Integer(o.getValue())));
//        list.stream().map(d->d.getmTag()).reduce()
        /* if (list != null && list.size() > 0) {
            XmMainMonth month = xmMainMonthService.get(entity.getMainMonthId());
            //正常
            int zccount = 0;
            //出勤
            int cqcount = 0;
            //早退
            int ztcount = 0;
            //迟到
            int cdcount = 0;
            //未打卡
            int wdkcount = 0;
            //旷工
            int kgcount = 0;
            for (XmMainDay xd : list) {
                switch (xd.getmTag()) {//TODO
                    case 0://早上正常
                    {
                        switch (xd.getpTag()) {//下午
                            case 0://正常
                            {
                                zccount++;
                                cqcount++;
                                break;
                            }
                            case 1://早退
                            {
                                ztcount++;
                                cqcount++;
                                break;
                            }
                            case 2://未打卡
                            {
                                wdkcount++;
                                cqcount++;
                                break;
                            }
                            case 3://其它，数据不正确，整天按旷工处理
                            {
                                kgcount++;
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    }
                    case 1://早上迟到
                        switch (xd.getpTag()) {//下午
                            case 0://正常
                            {
                                cqcount++;
                                cdcount++;
                                break;
                            }
                            case 1://早退
                            {
                                cdcount++;
                                ztcount++;
                                cqcount++;
                                break;
                            }
                            case 2://未打卡
                            {
                                cdcount++;
                                wdkcount++;
                                cqcount++;
                                break;
                            }
                            case 3://其它，数据不正确，整天按旷工处理
                            {
                                kgcount++;
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case 2://早上未打卡
                        switch (xd.getpTag()) {//下午
                            case 0://正常
                            {
                                wdkcount++;
                                cqcount++;
                                break;
                            }
                            case 1://早退
                            {
                                wdkcount++;
                                ztcount++;
                                cqcount++;
                                break;
                            }
                            case 2://未打卡
                            {
                                kgcount++;
                                break;
                            }
                            case 3://其它，数据不正确，整天按旷工处理
                            {
                                kgcount++;
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    case 3://早上 数据不正确，整天按旷工处理
                    {
                        kgcount++;
                        break;
                    }
                    default:
                        break;
                }
            }
            month.setCd(cdcount);
            month.setZt(ztcount);
            month.setSj(zccount);
            month.setKg(kgcount);
            month.setWdk(wdkcount);
            month.setSjcqts(cqcount);*/
//            xmMainMonthService.update(month);
//        }
    }
}
