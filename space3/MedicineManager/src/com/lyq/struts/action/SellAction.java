package com.lyq.struts.action;

import com.lyq.dao.MedicineDao;
import com.lyq.dao.SellDao;
import com.lyq.persistence.Medicine;
import com.lyq.persistence.SellDetail;
import com.lyq.persistence.User;
import com.lyq.struts.form.SellDetailForm;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ����Action��
 *
 * @author Li Yong Qiang
 */
public class SellAction extends BaseAction {
    //���ﳵ�����ҩƷ
    public ActionForward order(ActionMapping mapping, ActionForm form,
                               HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //��ȡSellDetailForm
        SellDetailForm sdf = (SellDetailForm) form;
        if (sdf != null && sdf.getSellPrice() > 0 && sdf.getMedId() > 0) {
            MedicineDao medDao = new MedicineDao();
            //����ҩƷ��Ϣ
            Medicine med = medDao.loadMedicine(sdf.getMedId());
            //������������С�ڿ�����������д�����
            if (med.getMedCount() < sdf.getSellCount()) {
                ActionMessages errors = new ActionMessages();
                ActionMessage message = new ActionMessage("drug.drugCount.error", "");
                errors.add("", message);
                this.saveErrors(request, errors);
                return mapping.findForward("error");
            }
            sdf.setSellTime(new Date());
            //�����ܼ�
            double sum = sdf.getSellPrice() * sdf.getSellCount();
            sdf.setTotal(sum);
            HttpSession session = request.getSession();
            // ��ȡ����
            List list = (List) session.getAttribute("order");
            List meds = new ArrayList();    // ʵ����һ��List����
            if (list == null) {
                sdf.setId(1);
            } else {
                int i = 1;
                // ��������ӵ�ҩƷ
                for (; i <= list.size(); i++) {
                    SellDetailForm temp = (SellDetailForm) list.get(i - 1);
                    temp.setId(i);
                    sum += temp.getTotal();    //�����ܼ۸�
                    meds.add(temp);
                }
                sdf.setId(i);
            }
            meds.add(sdf);
            // ���ܼ۱��浽session֮��
            session.setAttribute("sum", new Double(sum));
            // ���µĶ������浽session֮��
            session.setAttribute("order", meds);
        }
        return mapping.findForward("order");
    }

    //ѡ��ҩƷ
    public ActionForward add(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        SellDetailForm sdf = (SellDetailForm) form;
        if (sdf.getId() > 0) {
            MedicineDao medDao = new MedicineDao();
            Medicine med = medDao.loadMedicine(sdf.getId());
            sdf.setMedId(med.getId());
            sdf.setSellName(med.getName());
            sdf.setSellPrice(med.getPrice());
            sdf.setSellCount(1);
            sdf.setFactoryAdd(med.getFactoryAdd());
        }
        return mapping.findForward("add");
    }

    //���˹��ﳵ�е�ҩƷ
    public ActionForward buy(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        //��ȡ���ﳵ������ҩƷ
        List list = (List) session.getAttribute("order");
        if (list != null && list.size() > 0) {
            try {
                SellDao dao = new SellDao();
                MedicineDao medDao = new MedicineDao();
                //��ȡ��ǰ����Ա���û���
                User user = (User) request.getSession().getAttribute("user");
                //ͨ��ѭ�����н���
                for (int i = 0; i < list.size(); i++) {
                    SellDetailForm sdf = (SellDetailForm) list.get(i);
                    //����ҩƷ��Ϣ
                    Medicine med = medDao.loadMedicine(sdf.getMedId());
                    int dCount = med.getMedCount();
                    int sCount = sdf.getSellCount();
                    //�������������㹻�����н��ˣ�������д�����
                    if (dCount >= sCount) {
                        SellDetail sd = new SellDetail();
                        sd.setSellCount(sdf.getSellCount());
                        sd.setSellName(sdf.getSellName());
                        sd.setSellPrice(sdf.getSellPrice());
                        sd.setSellTime(new Date());
                        sd.setMed(med);
                        sd.setUser(user);
                        //����������ϸ
                        dao.saveSellDetail(sd);
                        //���¿�����Ϣ
                        med.setMedCount(dCount - sCount);
                        medDao.saveOrUpdate(med);
                    } else {
                        ActionMessages errors = new ActionMessages();
                        ActionMessage message = new ActionMessage(
                                "drug.drugCount.error", "");
                        errors.add("", message);
                        this.saveErrors(request, errors);
                        return mapping.findForward("error");
                    }
                }
            } finally {
                session.removeAttribute("order");
                session.removeAttribute("sum");
            }
        }
        return mapping.findForward("paging");
    }

    //��ҳ��ѯ������ϸ
    public ActionForward paging(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //��ȡ��ǰҳ��
        String currPage = request.getParameter("currPage");
        String action = request.getContextPath()
                + "/sell/sell.do?command=paging";
        String hql = "from SellDetail s order by s.sellTime desc";
        //��ҳ��ѯ
        Map map = this.getPage(hql, recPerPage, currPage, action, null);
        //��������ŵ�request��
        request.setAttribute("list", map.get("list"));
        //��������ŵ���ҳ����
        request.setAttribute("pagingBar", map.get("bar"));
        return mapping.findForward("findAllSuccess");
    }

    //ɾ�����ﳵ��ָ����ҩƷ
    public ActionForward deleteOrder(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //��ȡid
        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            HttpSession session = request.getSession();
            //��ȡ���ﳵ
            List order = (List) session.getAttribute("order");
            List list = null;
            if (order != null) {
                //��ȡ�ܶ�
                double sum = ((Double) session.getAttribute("sum"))
                        .doubleValue();
                //�����µĹ��ﳵ����
                list = new ArrayList();
                for (int i = 0; i < order.size(); i++) {
                    SellDetailForm sdf = (SellDetailForm) order.get(i);
                    if (!id.equals(String.valueOf(sdf.getId()))) {
                        list.add(sdf);
                    } else {
                        sum -= sdf.getTotal();
                    }
                }
                session.setAttribute("order", list);
                session.setAttribute("sum", new Double(sum));
            }
        }
        return mapping.findForward("order");
    }

    //ģ����ѯ����ҳ��ʾ
    public ActionForward blurQuery(ActionMapping mapping, ActionForm form,
                                   HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //��ȡ�ؼ���
        String keyWord = request.getParameter("keyWord");
        String action = request.getContextPath()
                + "/sell/sell.do?command=blurQuery";
        //HQL��ѯ���
        String hql = "from SellDetail s";
        //��ȡ��ǰҳ��
        String currPage = request.getParameter("currPage");
        Object[] where = null;
        // ת��
        if (currPage != null && !currPage.isEmpty()) {
            keyWord = new String(keyWord.getBytes("iso-8859-1"), "gbk");
        }
        if (keyWord != null && !keyWord.isEmpty()) {
            action += "&keyWord=" + keyWord;
            keyWord = "%" + keyWord + "%";
            hql += " where s.sellName like ?";
            where = new Object[]{keyWord};
        }
        //��ҳ��ѯ
        Map map = this.getPage(hql, recPerPage, currPage, action, where);
        //��������ŵ�request��
        request.setAttribute("list", map.get("list"));
        //��������ŵ���ҳ����
        request.setAttribute("pagingBar", map.get("bar"));
        return mapping.findForward("findAllSuccess");
    }

    // ��ն���
    public ActionForward clear(ActionMapping mapping, ActionForm form,
                               HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        session.removeAttribute("sum");
        session.removeAttribute("order");
        return mapping.findForward("order");
    }

    // ��ѯָ��ʱ��ε�������ϸ
    public ActionForward today(ActionMapping mapping, ActionForm form,
                               HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //��ȡ��ǰҳ��
        String currPage = request.getParameter("currPage");
        String action = request.getContextPath() + "/sell/sell.do?command=today";
        String begin = request.getParameter("begin");    // ��ʼʱ��
        String end = request.getParameter("end");        // ����ʱ��
        // ��ѯ����
        SimpleDateFormat sdf = null;
        if (begin == null || begin.isEmpty() || end == null || end.isEmpty()) {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(new Date());
            begin = date;
            end = date;
        }
        action += "&begin=" + begin + "&end=" + end;
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        begin += " 00:00:00";
        end += " 23:59:59";
        //��ҳ��ѯ
        Object[] where = new Object[]{sdf.parse(begin), sdf.parse(end)};
        String hql = "from SellDetail s where s.sellTime between ? and ?";
        Map map = this.getPage(hql, recPerPage, currPage, action, where);
        //��������ŵ�request��
        request.setAttribute("list", map.get("list"));
        //��������ŵ���ҳ����
        request.setAttribute("pagingBar", map.get("bar"));
        return mapping.findForward("findAllSuccess");
    }

    // ��������
    public ActionForward sequence(ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        SellDao dao = new SellDao();
        List list = dao.sellSeq();
        if (list != null && list.size() > 0) {
            request.setAttribute("list", list);
        }
        return mapping.findForward("sequence");
    }

    // ��������ҩƷid��ѯ������Ϣ
    public ActionForward findByMedId(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String id = request.getParameter("id");
        //��ȡ��ǰҳ��
        String currPage = request.getParameter("currPage");
        String action = request.getContextPath()
                + "/sell/sell.do?command=findByMedId";
        String hql = "from SellDetail s";
        Object[] where = null;
        if (id != null && !id.isEmpty()) {
            hql += " where s.med.id = ? order by s.sellTime desc";
            action += "&id=" + id;
            where = new Object[]{Integer.getInteger(id)};
        }
        //�ֲ���ѯ
        Map map = this.getPage(hql, recPerPage, currPage, action, where);
        //��������ŵ�request��
        request.setAttribute("list", map.get("list"));
        //��������ŵ���ҳ����
        request.setAttribute("pagingBar", map.get("bar"));
        return mapping.findForward("findAllSuccess");
    }
}
