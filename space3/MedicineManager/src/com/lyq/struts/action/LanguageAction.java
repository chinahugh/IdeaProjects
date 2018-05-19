package com.lyq.struts.action;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * ���ʻ�Action��
 *
 * @author Li Yong Qiang
 */
public class LanguageAction extends Action {
    //ѡ������
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //��ȡ��ѡ�����������
        String lan = request.getParameter("lan");
        if (lan != null) {
            //��������
            Locale currentLocale = null;
            //zh�������ģ�en��Ӣ��
            if ("zh".equals(lan)) {
                //��������Locale
                currentLocale = new Locale("zh", "CN");
            } else if ("en".equals(lan)) {
                //����Ӣ��Locale
                currentLocale = new Locale("en", "US");
            }
            //���������Է���Struts��Globals.LOCALE_KEY��
            request.getSession().setAttribute(Globals.LOCALE_KEY, currentLocale);
        }
        //���û�е�¼���ص���¼ҳ�棬���򷵻ص�����ҳ��
        if (request.getSession().getAttribute("user") == null) {
            return mapping.findForward("login");
        } else {
            return mapping.findForward("manage");
        }
    }
}
