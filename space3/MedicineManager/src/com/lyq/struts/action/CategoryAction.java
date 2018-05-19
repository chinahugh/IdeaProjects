package com.lyq.struts.action;

import com.lyq.dao.CategoryDao;
import com.lyq.persistence.Category;
import com.lyq.struts.form.CategoryForm;
import com.lyq.util.ChartUtil;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;
//import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * ҩƷ���Action��
 *
 * @author Li Yong Qiang
 */
public class CategoryAction extends BaseAction {

    //��ӻ��޸����
    public ActionForward add(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //��ȡ�����Ϣ
        CategoryForm cf = (CategoryForm) form;
        //����Category����
        Category c = new Category();
        c.setName(cf.getName());
        c.setDescription(cf.getDescription());
        c.setCreateTime(new Date());
        if (cf.getId() != 0) {
            c.setId(cf.getId());
        }
        CategoryDao dao = new CategoryDao();
        dao.saveOrUpdate(c);
        return mapping.findForward("paging");
    }

    //��ѯ���
    public ActionForward findAll(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List list = null;
        CategoryDao dao = new CategoryDao();
        list = dao.findByHQL("from Category");
        request.setAttribute("list", list);
        return mapping.findForward("findAllSuccess");
    }

    //�༭���
    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CategoryForm cf = (CategoryForm) form;
        // �ж�id�Ƿ���Ч
        if (cf.getId() > 0) {
            CategoryDao dao = new CategoryDao();
            Category c = dao.loadCategory(cf.getId());
            BeanUtils.copyProperties(cf, c);
        }
        return mapping.findForward("edit");
    }

    //ɾ�����
    public ActionForward delete(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        CategoryForm cf = (CategoryForm) form;
        // �ж�id�Ƿ���Ч
        if (cf.getId() > 0) {
            CategoryDao dao = new CategoryDao();
            Category c = dao.loadCategory(cf.getId());
            dao.delete(c);    //ɾ�����
        }
        return mapping.findForward("paging");
    }

    //��ҳ
    public ActionForward paging(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //��ȡ��ǰҳ��
        String currPage = request.getParameter("currPage");
        String action = request.getContextPath() + "/baseData/category.do?command=paging";
        String hql = "from Category";
        //��ҳ��ѯ
        Map map = this.getPage(hql, recPerPage, currPage, action, null);
        //��������ŵ�request��
        request.setAttribute("list", map.get("list"));
        //��������ŵ���ҳ����
        request.setAttribute("pagingBar", map.get("bar"));
        return mapping.findForward("findAllSuccess");
    }

    // ͳ��ҩƷ�������
    public ActionForward findCategoryAndCound(ActionMapping mapping, ActionForm form,
                                              HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // ʵ����CategoryDao����
        CategoryDao dao = new CategoryDao();
        // ��ѯҩƷ�������
        List list = dao.findCategoryAndCount();
        ChartUtil chartUtil = new ChartUtil();
        // ����JFreeChartʵ��
        JFreeChart chart = chartUtil.categoryChart(list);
        if (chart != null) {
            // ��ȡͼƬ�ļ���
            String fileName = ServletUtilities.saveChartAsJPEG(chart, 500, 300, request.getSession());
            // ��ȡͼƬ��ַ
            String graphURL = request.getContextPath() + "/DisplayChart?filename=" + fileName;
            // ��ͼƬ��ַ���õ�request��
            request.setAttribute("graphURL", graphURL);
        }
        // ҳ��ת��
        return mapping.findForward("categoryGraph");
    }
}

class BeanUtils {

    public static void copyProperties(CategoryForm cf, Category c) {

    }
}
