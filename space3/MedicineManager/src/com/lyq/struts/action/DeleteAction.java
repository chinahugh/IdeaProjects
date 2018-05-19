package com.lyq.struts.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * ����ɾ��Action��
 * �̳�LookupDispatchAction��
 *
 * @author Li Yong Qiang
 */
public class DeleteAction extends LookupDispatchAction {
    //�û������֤
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //�ж��û��Ƿ��¼
        if (request.getSession().getAttribute("user") == null) {
            return mapping.findForward("login");
        }
        return super.execute(mapping, form, request, response);
    }

    //��дLookupDispatchAction���getKeyMethodMap()����
    protected Map getKeyMethodMap() {
        Map map = new HashMap();
        //ɾ����ѡ
        map.put("button.delete.selected", "selected");
        //ɾ��ȫ��
        map.put("button.delete.all", "all");
        return map;
    }
}
