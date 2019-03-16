package springboot.com.mvc.service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.com.mvc.entity.XmMainDay;
import springboot.com.mvc.entity.XmMainMonth;
import springboot.com.mvc.mapper.XmMainMonthMapper;
import springboot.com.mvc.service.XmMainDayService;
import springboot.com.mvc.service.XmMainMonthService;
import springboot.com.mvc.util.TimeTagUtils;
import springboot.template.global.exception.ServiceException;
import springboot.template.global.util.UUIDUtils;
import springboot.template.mvc.entity.UserInfo;
import springboot.template.mvc.service.UserInfoService;
import springboot.template.mvc.util.DateUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/8/9
 * @Description XmMainMonthServiceImpl
 */
@Service("xmMainMonthService")
@Transactional(rollbackFor = Exception.class)
public class XmMainMonthServiceImpl implements XmMainMonthService {
    @Resource
    private XmMainMonthMapper xmMainMonthMapper;
    @Resource
    private XmMainDayService xmMainDayService;
    @Resource
    private UserInfoService userInfoService;

    @Override
    public XmMainMonth get(String id) {
        XmMainMonth entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = xmMainMonthMapper.get(id);
        }
        return entity;
    }

    @Override
    public XmMainMonth select(XmMainMonth entity) {
        if (entity == null) {
            return null;
        }
        return xmMainMonthMapper.select(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public int deleteByKey(String id) {
        if (StringUtils.isBlank(id)) {
            return 0;
        }
        XmMainMonth xmMainMonth = xmMainMonthMapper.get(id);
        //设置失效，不删除 TODO
        xmMainMonth.setIsDisable(1);
        int update = xmMainMonthMapper.update(xmMainMonth);
        return update;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public int insert(XmMainMonth entity) {
        if (entity == null) {
            return 0;
        }
        entity.setYcqts(DateUtils.getMonthDays(entity.getSysYear(), entity.getSysMonth()));
        entity.initDateEntity();
        entity.setId(UUIDUtils.getUUid());
        return xmMainMonthMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = ServiceException.class, readOnly = false)
    public int update(XmMainMonth entity) {
        if (entity == null) {
            return 0;
        }
        entity.setYcqts(DateUtils.getMonthDays(entity.getSysYear(), entity.getSysMonth()));
        entity.initDateEntity();
        return xmMainMonthMapper.update(entity);
    }

    @Override
    public List<XmMainMonth> list(XmMainMonth entity) {
        if (entity == null) {
            entity = new XmMainMonth();
        }
        List<XmMainMonth> list = xmMainMonthMapper.list(entity);
        if (list != null) {
            for (XmMainMonth x : list) {
                UserInfo userInfo = userInfoService.get(x.getUserId());
                if (userInfo!=null){
                    x.setUserName(userInfo.getName());
                }
            }
        }
        return list;
    }

    @Override
    public PageInfo<XmMainMonth> list(XmMainMonth entity, Page<XmMainMonth> page) {
        if (page == null) {
            page = new Page<>();
        }
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<XmMainMonth> list = list(entity);
        if (list != null && list.size() > 0) {
            return new PageInfo<>(list);
        }
        return null;
    }

    @Override
    public void update() {
        XmMainMonth xmMainMonth = new XmMainMonth();
        xmMainMonth.setSysYear(2018);
        xmMainMonth.setSysMonth(1);
        List<XmMainMonth> list = xmMainMonthMapper.list(xmMainMonth);
        for (XmMainMonth x : list) {
            upMouth(x.getId());
        }
    }

    /**
     * 根据mainMonthId计算XmMainMonth的变化
     *
     * @param mainMonthId
     */
    @Override
    public void upMouth(String mainMonthId) {
        XmMainDay xmMainDay = new XmMainDay();
        if (StringUtils.isBlank(mainMonthId)) {
            throw new ServiceException("mainMonthId为NULL");
        }
        //更新实际出勤天数
        xmMainDay.setMainMonthId(mainMonthId);
        xmMainDay.setIsDisable(0);
        List<XmMainDay> list = xmMainDayService.list(xmMainDay);
        XmMainMonth xmMainMonth = xmMainMonthMapper.get(mainMonthId);
        xmMainMonth.setSjcqts(list.size());
        //迟到
        int cd = 0;
        //早退
        int zt = 0;
        //未打卡
        int wdk = 0;
        for (XmMainDay x : list) {
            if (TimeTagUtils.TAG_CD.equals(x.getmTag())) {
                cd++;
            }
            if (TimeTagUtils.TAG_ZT.equals(x.getpTag())) {
                zt++;
            }
            if (TimeTagUtils.TAG_WDK.equals(x.getmTag())) {
                wdk++;
            }
            if (TimeTagUtils.TAG_WDK.equals(x.getpTag())) {
                wdk++;
            }
        }
        //更新迟到次数
        xmMainMonth.setCd(cd);
        //更新早退次数
        xmMainMonth.setZt(zt);
        //更新未打卡
        xmMainMonth.setWdk(wdk);
        xmMainMonthMapper.update(xmMainMonth);
    }
}
