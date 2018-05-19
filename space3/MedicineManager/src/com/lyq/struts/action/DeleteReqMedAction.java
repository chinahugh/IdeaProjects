package com.lyq.struts.action;

import com.lyq.dao.MedicineDao;
import com.lyq.util.StringUtil;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����ɾ��ҩƷ������ϢAction��
 * LookupDispatchAction������
 *
 * @author Li Yong Qiang
 */
public class DeleteReqMedAction extends DeleteAction {
    MedicineDao dao = new MedicineDao();

    //ɾ��ȫ��
    public ActionForward all(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameterValues("allId");
        if (ids != null && ids.length > 0) {
            dao.deleteByHQL("update Medicine d set d.reqCount=0 where d.id in(" + StringUtil.arr2Str(ids) + ")");
        }
        return mapping.findForward("findAllSuccess");
    }

    //ɾ����ѡ
    public ActionForward selected(ActionMapping mapping, ActionForm form,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception {
        String[] ids = request.getParameterValues("selectedId");
        if (ids != null && ids.length > 0) {
            dao.deleteByHQL("update Medicine d set d.reqCount=0 where d.id in(" + StringUtil.arr2Str(ids) + ")");
        }
        return mapping.findForward("findAllSuccess");
    }
}
