package springboot.com.mvc.service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import springboot.com.mvc.entity.XmMainDay;
import springboot.com.mvc.entity.XmMainMonth;
import springboot.com.mvc.mapper.XmMainDayMapper;
import springboot.com.mvc.service.XmMainDayService;
import springboot.com.mvc.service.XmMainMonthService;
import springboot.com.util.TimeTagUtils;
import springboot.template.global.exception.ServiceException;
import springboot.template.global.util.UUIDUtils;
import springboot.template.mvc.util.DateUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/8/8
 * @Description XmMainDayServiceImpl
 */
@Service
public class XmMainDayServiceImpl implements XmMainDayService {
    @Resource
    private XmMainDayMapper xmMainDayMapper;
    @Resource
    private XmMainMonthService xmMainMonthService;

    /**
     * 查找一个实例
     *
     * @param id
     * @return
     */
    @Override
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
    public int deleteByKey(String id) {
        if (StringUtils.isBlank(id)) {
            return 0;
        }
        XmMainDay xmMainDay = xmMainDayMapper.get(id);
        xmMainDay.setIsDisable(1);
        xmMainDayMapper.update(xmMainDay);
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
        entity(entity);
        int a = xmMainDayMapper.insert(entity);
        jsMainMounth(entity);
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
        entity(entity);
        xmMainDayMapper.update(entity);
        jsMainMounth(entity);
        return 1;
    }

    /**
     * 列表
     *
     * @param entity
     * @return
     */
    @Override
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
    private void entity(XmMainDay entity) {
        /*上班标志*/
        entity.setmTag(TimeTagUtils.getmTag(entity.getmData()));
        /*下班标志*/
        entity.setpTag(TimeTagUtils.getpTag(entity.getpData()));
        /*记录时间插入或更新*/
        entity.initDateEntity();
    }

    /**
     * 根据entity计算XmMainMonth的变化
     *
     * @param entity
     */
    private void jsMainMounth(XmMainDay entity) {
        XmMainDay xmMainDay = new XmMainDay();
        if (StringUtils.isBlank(entity.getMainMonthId())) {
            throw new ServiceException("XmMainDay中mainMonthId为NULL");
        }
        xmMainDay.setMainMonthId(entity.getMainMonthId());
        List<XmMainDay> list = xmMainDayMapper.list(xmMainDay);
        if (list != null && list.size() > 0) {
            XmMainMonth month = xmMainMonthService.get(entity.getMainMonthId());
            //早退
            int ztcount = 0;
            //迟到
            int cdcount = 0;
            //未打卡
            int wdkcount = 0;
            //未上班
            int wsbcount = 0;
            for (XmMainDay xd : list) {
                //整体上班数据异常按未上班算
                if (xd.getmTag().intValue() == TimeTagUtils.TAG_QT.intValue()
                        && xd.getpTag().intValue() == TimeTagUtils.TAG_QT.intValue()) {
                    wsbcount++;
                    continue;
                }
                //早晚都未打卡即未上班
                if (xd.getmTag().intValue() == TimeTagUtils.TAG_WDK.intValue()
                        && xd.getpTag().intValue() == TimeTagUtils.TAG_WDK.intValue()) {
                    wsbcount++;
                } else {
                    //迟到
                    if (xd.getmTag().intValue() == TimeTagUtils.TAG_CD.intValue()) {
                        cdcount++;
                    }
                    //早退
                    if (xd.getpTag().intValue() == TimeTagUtils.TAG_ZT.intValue()) {
                        ztcount++;
                    }
                }
            }
            month.setCd(cdcount);
            month.setZt(ztcount);
            month.setSjcqts(DateUtils.getMonthDays(month.getSysMonth()) - wsbcount);
            xmMainMonthService.update(month);
        }
    }
}
