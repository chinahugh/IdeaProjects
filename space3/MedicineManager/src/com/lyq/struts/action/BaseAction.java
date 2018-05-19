package com.lyq.struts.action;

import com.lyq.dao.SupperDao;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.util.MessageResources;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * ���ڼ̳У������û��Ƿ��¼����ҳ
 *
 * @author Li Yong Qiang
 */
public class BaseAction extends DispatchAction {

    protected int recPerPage = 3; // ��ҳ��ÿҳ�ļ�¼��
    protected Locale locale = null; // ����������Ϣ
    protected MessageResources message = null;// ��Ϣ��Դ

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // ��ȡLocale��Ϣ
        this.locale = this.getLocale(request);
        // ��ȡ��Ϣ��Դ����
        this.message = this.getResources(request);
        // ����û�û�е�¼����ת����¼ҳ��
        if (request.getSession().getAttribute("user") == null) {
            return mapping.findForward("login");
        }
        return super.execute(mapping, form, request, response);
    }

    /**
     * ��ҳ
     *
     * @param hql        hql��䣨������select,��from�Ӿ俪ʼ��
     * @param recPerPage ÿҳ�ļ�¼��
     * @param currPage   ��ǰҳ��
     * @param action     �����ύ��action��ַ
     * @param where      ��������
     * @return Map����(װ�ؽ�������󼰷�ҳ��)
     */
    public Map getPage(String hql, int recPerPage, String currPage,
                       String action, Object[] where) {
        // ʵ����һ��Map����
        Map map = new HashMap();
        // ��ҳ��
        StringBuffer pagingBar = new StringBuffer();
        List list = null; // �����
        int iCurrPage = 1; // ��ǰҳ��
        // ���������ҳ����Ե�ǰҳ�븳ֵ
        if (currPage != null && !currPage.isEmpty()) {
            iCurrPage = Integer.parseInt(currPage);
        }
        // ʵ����SupperDao����
        SupperDao dao = new SupperDao();
        int pages = 0; // ��ҳ��
        // ��ȡ�ܼ�¼��
        Long l = (Long) dao.uniqueResult("select count(*) " + hql, where);
        int count = l.intValue(); // ���ܼ�¼��תΪint��
        if (count > 0) {
            // ������ҳ��
            if (count % recPerPage == 0) {
                pages = count / recPerPage;
            } else {
                pages = count / recPerPage + 1;
            }
            if (iCurrPage > pages) {
                iCurrPage = pages;
            }
            if (iCurrPage < 1) {
                iCurrPage = 1;
            }
            // ��ҳ��ѯ��ȡ�����
            list = dao.findPaging(hql, (iCurrPage - 1) * recPerPage,
                    recPerPage, where);
            // �����ҳ��
            pagingBar.append("<form name='pagingForm' action='" + action
                    + "' method='post'>");
            // �ڷ�ҳ��������ܼ�¼��
            pagingBar.append(message.getMessage(locale, "page.totalRecord")
                    + count);
            pagingBar.append("   ");
            pagingBar.append(message.getMessage(locale, "system.total") + "  "
                    + pages + "  " + message.getMessage(locale, "page.page"));
            pagingBar.append("   ");
            // ҳ������1��ʾ��һҳ�����ӣ�������ʾ������
            if (iCurrPage > 1) {
                pagingBar.append("<a href=" + action + "&currPage=1>"
                        + message.getMessage(locale, "page.first") + "</a>");
                pagingBar.append("   ");
                pagingBar.append("<a href=" + action + "&currPage="
                        + (iCurrPage - 1) + ">"
                        + message.getMessage(locale, "page.previous") + "</a>");
                pagingBar.append("   ");
            } else {
                pagingBar.append(message.getMessage(locale, "page.first"));
                pagingBar.append("   ");
                pagingBar.append(message.getMessage(locale, "page.previous"));
                pagingBar.append("   ");
            }
            // ��ʾ��ǰҳ��
            pagingBar.append("<font color='red'>" + iCurrPage + "</font>");
            pagingBar.append("   ");
            // ҳ��С����ҳ����ʾ��һҳ�����ӣ�������ʾ������
            if (iCurrPage < pages) {
                pagingBar.append("<a href=" + action + "&currPage="
                        + (iCurrPage + 1) + ">"
                        + message.getMessage(locale, "page.next") + "</a>");
                pagingBar.append("   ");
                pagingBar.append("<a href=" + action + "&currPage=" + pages
                        + ">" + message.getMessage(locale, "page.last")
                        + "</a>");
            } else {
                pagingBar.append(message.getMessage(locale, "page.next"));
                pagingBar.append("   ");
                pagingBar.append(message.getMessage(locale, "page.last"));
            }
            pagingBar.append("   ");
            pagingBar.append("<input type='text' name='currPage' size='1'>");
            pagingBar.append("<input type='submit' value='GO'>");
            pagingBar.append("</form>");
        }
        map.put("list", list);// �����
        map.put("bar", pagingBar.toString());// ��ҳ�����ַ�����ʽ
        return map;
    }
}
