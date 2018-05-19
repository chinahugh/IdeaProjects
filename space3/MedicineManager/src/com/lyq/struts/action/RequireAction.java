package com.lyq.struts.action;

import com.lyq.dao.CategoryDao;
import com.lyq.dao.MedicineDao;
import com.lyq.persistence.Category;
import com.lyq.persistence.Medicine;
import com.lyq.struts.form.MedicineForm;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ҩƷ����Action��
 *
 * @author Li Yong Qiang
 */
public class RequireAction extends BaseAction {
    //�༭����ҩƷ
    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MedicineForm df = (MedicineForm) form;
        if (df.getId() > 0) {
            MedicineDao dao = new MedicineDao();
            Medicine med = dao.loadMedicine(df.getId());
            BeanUtils.copyProperties(df, med);
            df.setCategoryId(med.getCategory().getId());
        }
        //��ȡҩƷ�����Ϣ
        CategoryDao dao = new CategoryDao();
        List cs = dao.findAllCategory();
        request.setAttribute("cs", cs);
        return mapping.findForward("medSave");
    }

    //�������ҩƷ
    public ActionForward add(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Medicine med = null;
        MedicineForm df = (MedicineForm) form;
        if (df.getReqCount() == 0) {
            df.setReqCount(1);
        }
        MedicineDao medDao = new MedicineDao();
        //�����Ѵ��ڣ���������
        if (df.getId() > 0) {
            med = medDao.loadMedicine(df.getId());
            //����������
            int reqCount = med.getReqCount();
            med.setReqCount(df.getReqCount());
        } else {//���󲻴��ڣ��������
            med = new Medicine();
            BeanUtils.copyProperties(med, df);
            CategoryDao cd = new CategoryDao();
            Category category = cd.loadCategory(df.getCategoryId());
            med.setCategory(category);
        }
        //�ϴ�
        FormFile photo = df.getPhoto();
        if (photo != null && photo.getFileSize() > 0) {
            String realPath = this.getServlet().getServletContext().getRealPath("/upload");
            System.out.println(realPath);
            //���ļ��ϴ�����������ָ�����ļ���
            try {
                String fname = photo.getFileName();                    //��ȡ�ϴ��ļ�����
                if (fname.indexOf(".") != -1) {
                    String endWith = fname.substring(fname.lastIndexOf("."), fname.length());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                    fname = sdf.format(new Date()) + endWith;
                }
                //���������д���ļ�
                OutputStream out = new FileOutputStream(realPath + "/" + fname);    //����д���������ַ�����������
                out.write(photo.getFileData());
                out.flush();
                out.close();
                med.setPhotoPath(fname);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        medDao.saveOrUpdate(med);
        return mapping.findForward("addSuccess");
    }

    //����������Ϣ
    public ActionForward update(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MedicineForm df = (MedicineForm) form;
        Medicine med = null;
        if (df.getId() > 0) {
            MedicineDao dao = new MedicineDao();
            med = dao.loadMedicine(df.getId());
            BeanUtils.copyProperties(df, med);
        }
        return mapping.findForward("medUpdate");
    }

    //����medNo��ѯ
    public ActionForward findMedicineByMedNo(ActionMapping mapping, ActionForm form,
                                             HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MedicineForm df = (MedicineForm) form;
        Medicine med = null;
        //��ѯ�������Ƿ����
        if (df != null && df.getMedNo() != null) {
            MedicineDao dao = new MedicineDao();
            med = dao.findMedicineByMedNo(df.getMedNo());
        }
        if (med != null) {
            //�鵽��Ϣ
            //request.setAttribute("med", "med");
            BeanUtils.copyProperties(df, med);
            return mapping.findForward("medUpdate");
        } else {
            CategoryDao cd = new CategoryDao();
            List list = cd.findByHQL("from Category");
            request.setAttribute("cs", list);
            return mapping.findForward("medSave");
        }
    }

    //��ҳ��ѯ
    public ActionForward paging(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //��ȡ��ǰҳ��
        String currPage = request.getParameter("currPage");
        String action = request.getContextPath() + "/require/require.do?command=paging";
        String hql = "from Medicine d where d.reqCount > 0 or d.medCount <= 0";
        //��ҳ��ѯ
        Map map = this.getPage(hql, recPerPage, currPage, action, null);
        //��������ŵ�request��
        request.setAttribute("list", map.get("list"));
        //��������ŵ���ҳ����
        request.setAttribute("pagingBar", map.get("bar"));
        return mapping.findForward("findAllSuccess");
    }

    //����ҩƷ�������
    public ActionForward meded(ActionMapping mapping, ActionForm form,
                               HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        MedicineForm df = (MedicineForm) form;    // ��ȡMedicineForm
        Medicine med = null;
        if (df.getId() > 0) {
            MedicineDao dao = new MedicineDao();    // ʵ����MedicineDao
            med = dao.loadMedicine(df.getId());        // ����ҩƷ��Ϣ
            if (med != null) {
                // ����ҩƷ����
                med.setMedCount(med.getMedCount() + med.getReqCount());
                med.setReqCount(0);        // ����ҩƷ����
                dao.saveOrUpdate(med);    // ����ҩƷ����
            }
        }
        return mapping.findForward("addSuccess");
    }

    //ģ����ѯ,��ҳ��ʾ
    public ActionForward blurQuery(ActionMapping mapping, ActionForm form,
                                   HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //��ȡ�ؼ���
        String keyWord = request.getParameter("keyWord");
        //��ȡ��ǰҳ��
        String currPage = request.getParameter("currPage");
        String action = request.getContextPath() + "/require/require.do?command=blurQuery";
        String hql = "from Medicine d where d.reqCount > 0";
        Object[] where = null;
        //ת��
        if (currPage != null && !currPage.isEmpty()) {
            keyWord = new String(keyWord.getBytes("iso-8859-1"), "gbk");
        }
        if (keyWord != null && !keyWord.isEmpty()) {
            keyWord = "%" + keyWord + "%";
            hql += " where d.name like ? or d.medNo like ? or d.factoryAdd like ? or d.description like ?";
            action += "&keyWord=" + keyWord;
            where = new Object[]{keyWord, keyWord, keyWord, keyWord};
        }
        //��ҳ��ѯ
        Map map = this.getPage(hql, recPerPage, currPage, action, where);
        //��������ŵ�request��
        request.setAttribute("list", map.get("list"));
        //��������ŵ���ҳ����
        request.setAttribute("pagingBar", map.get("bar"));
        return mapping.findForward("findAllSuccess");
    }


}
