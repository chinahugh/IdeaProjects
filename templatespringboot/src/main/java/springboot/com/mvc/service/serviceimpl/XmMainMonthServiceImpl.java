package springboot.com.mvc.service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.com.mvc.entity.XmMainMonth;
import springboot.com.mvc.mapper.XmMainMonthMapper;
import springboot.com.mvc.service.XmMainMonthService;
import springboot.template.global.exception.ServiceException;
import springboot.template.mvc.util.DateUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/8/9
 * @Description XmMainMonthServiceImpl
 */
@Service
public class XmMainMonthServiceImpl implements XmMainMonthService {
    @Resource
    private XmMainMonthMapper xmMainMonthMapper;

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
    public int deleteByKey(String id) {
        if (StringUtils.isBlank(id)) {
            return 0;
        }
        XmMainMonth xmMainMonth = xmMainMonthMapper.get(id);
        xmMainMonth.setIsDisable(1);
        return xmMainMonthMapper.update(xmMainMonth);
    }

    @Override
    public int insert(XmMainMonth entity) {
        if (entity == null) {
            return 0;
        }
        entity.setYcqts(DateUtils.getMonthDays(entity.getSysMonth()));
        entity.initDateEntity();
        return xmMainMonthMapper.insert(entity);
    }

    @Override
    @Transactional(rollbackFor = ServiceException.class)
    public int update(XmMainMonth entity) {
        if (entity == null) {
            return 0;
        }
        entity.setYcqts(DateUtils.getMonthDays(entity.getSysMonth()));
        entity.initDateEntity();
        return xmMainMonthMapper.update(entity);
    }

    public List<XmMainMonth> list(XmMainMonth entity) {
        if (entity == null) {
            return null;
        }
        return xmMainMonthMapper.list(entity);
    }

    @Override
    public PageInfo<XmMainMonth> list(XmMainMonth entity, Page<XmMainMonth> page) {
        if (entity == null) {
            return null;
        }
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
}
