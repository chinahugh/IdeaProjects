package springboot.com.mvc.service;

import springboot.com.mvc.entity.XmMainMonth;
import springboot.template.mvc.service.BaseService;

/**
 * @Auther HUGH
 * @Date 2018/8/6
 * @Description XmMainMonthService
 */

public interface XmMainMonthService extends BaseService<XmMainMonth> {
    void update();

    void upMouth(String mainMonthId);
    /**
     * 以isDisable=0为前提获取XmMainMonth.sysYear、sysMonth下的全月数据
     *
     * @param entity
     * @return
     */
//    public XmMainMonth getALLXmMainMonth(XmMainMonth entity) {
//        if (entity == null) {
//            return null;
//        }
//        if (entity.getUserId() == null || entity.getSysYear() == null || entity.getSysMonth() == null) {
//            return entity;
//        }
//        XmMainMonth xmMainMonth = select(entity);
//        if (xmMainMonth == null) {
//            return null;
//        }
//        XmMainDay xmMainDay = new XmMainDay();
//        xmMainDay.setUserId(entity.getUserId());
//        xmMainDay.setSysYear(entity.getSysYear());
//        xmMainDay.setSysMonth(entity.getSysMonth());
//        List<XmMainDay> list = xmMainDayService.list(xmMainDay);
//        if (list != null && list.size() > 0) {
//            xmMainMonth.setXmMainDayList(list);
//        }
//        return xmMainMonth;
//    }
//
//
//    @Override
//    public List<XmMainMonth> list(XmMainMonth entity) {
//        List<XmMainMonth> xmMainMonthList = super.list(entity);
//        List<XmMainDay> list=new ArrayList<>();
//        if (xmMainMonthList == null || xmMainMonthList.size() < 1) {
//            return null;
//        }
//        XmMainDay xmMainDay = new XmMainDay();
//        xmMainDay.setSysYear(entity.getSysYear());
//        xmMainDay.setSysMonth(entity.getSysMonth());
//        List<XmMainDay> xmMainDayList=xmMainDayService.list(xmMainDay);
//        if (xmMainDayList!= null&&xmMainDayList.size()>0) {
//            for (XmMainMonth xm : xmMainMonthList) {
//                if (xm != null && StringUtils.isNotBlank(xm.getUserId())) {
//                   for (XmMainDay xd: xmMainDayList){
//                       if (xd != null&& StringUtils.isNotBlank(xd.getUserId())) {
//                            if (xd.getXainMonthId().equals(xm.getId())){
//                               list.add(xd);
//                            }
//                       }
//                   }
//                   xm.setXmMainDayList(new ArrayList<>(list));
//                    list.clear();
//                }
//            }
//        }
//
//        return xmMainMonthList;
//    }
//
//    @Override
//    @Transactional(rollbackFor = ServiceException.class)
//    public int update(XmMainMonth entity) {
//         int i=super.update(entity);
//        List<XmMainDay> xmMainDayList = entity.getXmMainDayList();
//        for (XmMainDay xd:xmMainDayList){
//            xmMainDayService.update(xd);
//        }
//        return i;
//    }
//
//    @Override
//    public int insert(XmMainMonth entity) {
//        int i= super.insert(entity);
//        List<XmMainDay> xmMainDayList = entity.getXmMainDayList();
//        if (xmMainDayList != null&&xmMainDayList.size()>0) {
//            for (XmMainDay xd:xmMainDayList){
//                xd.setUserId(entity.getUserId());
//                xmMainDayService.insert(xd);
//            }
//        }
//        return i;
//    }
}
