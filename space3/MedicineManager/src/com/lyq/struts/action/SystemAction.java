package com.lyq.struts.action;

import com.lyq.dao.UserDao;
import com.lyq.persistence.User;
import com.lyq.struts.form.UserForm;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * ϵͳAction��
 *
 * @author Li Yong Qiang
 */
public class SystemAction extends BaseAction {

    //���û�д��ݲ���Ĭ�ϵ��ô˷���
    protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                        HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionForward forword = new ActionForward("/login.jsp", true);
        return forword;
    }

    // �û��˳�
    public ActionForward userExit(ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.getSession().removeAttribute("user");
        return mapping.findForward("login");
    }

    // ����û�
    public ActionForward userAdd(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserForm uf = (UserForm) form;
        if (uf != null) {
            //�����Ƿ���ȷ���������������û���Ϣ
            if (uf.getPassword().equals(uf.getRePassword())) {
                User user = new User();    // ʵ����һ��User����
                BeanUtils.copyProperties(user, uf);    // ��user���Ը�ֵ
                user.setCreateTime(new Date());        // �Դ���ʱ�����Ը�ֵ
                UserDao dao = new UserDao();        // ʵ����UserDao����
                dao.save(user);    // ����user����
            }
        }
        return mapping.findForward("userFind");
    }

    // ���������û�
    public ActionForward userFind(ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserDao dao = new UserDao();
        List list = dao.findByHQL("from User");
        if (list != null) {
            request.setAttribute("list", list);
        }
        return mapping.findForward("findAllSuccess");
    }

    // ɾ���û�
    public ActionForward userDelete(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserForm uf = (UserForm) form;
        if (uf.getId() > 0) {
            //��session֮�л�ȡUser����
            User u = (User) request.getSession().getAttribute("user");
            if (u != null) {
                //�û�����ɾ�������˺�
                if (uf.getId() != u.getId()) {
                    UserDao dao = new UserDao();
                    dao.deleteByHQL("delete from User u where u.id = " + uf.getId());
                } else {
                    //ɾ�������ش�����Ϣ
                    ActionMessages errors = new ActionMessages();
                    errors.add("", new ActionMessage("user.delete.error"));
                    this.saveErrors(request, errors);
                    return mapping.findForward("error");
                }
            }
        }
        return mapping.findForward("userFind");
    }

    // �༭�û�
    public ActionForward userEdit(ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        UserForm uf = (UserForm) form;
        if (uf.getId() > 0) {
            UserDao dao = new UserDao();
            User user = dao.loadUser(uf.getId());
            BeanUtils.copyProperties(uf, user);
        }
        return mapping.findForward("userEdit");
    }

    // �޸�����
    public ActionForward modifyPassword(ActionMapping mapping, ActionForm form,
                                        HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserForm uf = (UserForm) form;
        if (uf != null) {
            //��session֮�л�ȡUser����
            User user = (User) request.getSession().getAttribute("user");
            //ȷ�����������Ƿ�һ��
            if (user != null && uf.getOldPassword().equals(user.getPassword())) {
                if (uf.getPassword().equals(uf.getRePassword())) {
                    UserDao dao = new UserDao();
                    user.setPassword(uf.getPassword());
                    dao.saveOrUpdate(user);
                }
            } else {
                //�������
                ActionMessages errors = new ActionMessages();
                errors.add("", new ActionMessage("user.oldpassword.error"));
                this.saveErrors(request, errors);
                return mapping.findForward("error");
            }
        }
        return mapping.findForward("userFind");
    }

    //��ʼ��
    public ActionForward initialization(ActionMapping mapping, ActionForm form,
                                        HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserDao dao = new UserDao();
        //��ʼ������
        dao.initialization();
        request.getSession().invalidate();
        ActionForward forward = new ActionForward("/login.jsp", true);
        return forward;
    }


}
