package com.lyq.struts.action;

import com.lyq.dao.UserDao;
import com.lyq.persistence.User;
import com.lyq.struts.form.UserForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �û���¼Action��
 *
 * @author Li Yong Qiang
 */
public class LoginAction extends Action {
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserForm uf = (UserForm) form;        // ��ȡActionForm
        String userName = uf.getUsername();    // �û���
        String password = uf.getPassword();    // ����
        User user = null;
        // ��ѯ�û�
        if (userName != null && password != null) {
            UserDao userDao = new UserDao();
            user = userDao.login(userName, password);
        }
        // ��ѯ���û����¼�ɹ��������¼ʧ�ܷ��ص���¼ҳ��
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return mapping.findForward("manage");
        } else {
            request.setAttribute("error", "error");
            return mapping.findForward("loginFail");
        }
    }
}
