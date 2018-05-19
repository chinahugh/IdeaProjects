package com.lyq.struts.action;

import com.lyq.dao.CategoryDao;
import com.lyq.dao.MedicineDao;
import com.lyq.persistence.Category;
import com.lyq.persistence.Medicine;
import com.lyq.struts.form.MedicineForm;
import com.lyq.util.QueryUtil;
import com.lyq.util.StringUtil;
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
 * ??Action??
 *
 * @author Li Yong Qiang
 */
public class MedicineAction extends BaseAction {

    // ?????
    public ActionForward add(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Medicine med = null;
        // ???MedicineForm
        MedicineForm df = (MedicineForm) form;
        MedicineDao dao = new MedicineDao();
        if (df.getMedCount() == 0) {
            df.setMedCount(1);
        }
        med = new Medicine();
        BeanUtils.copyProperties(med, df);
        CategoryDao cd = new CategoryDao();
        Category category = cd.loadCategory(df.getCategoryId());
        med.setCategory(category);
        // ?????
        FormFile photo = df.getPhoto();
        if (photo != null && photo.getFileSize() > 0) {
            String realPath = this.getServlet().getServletContext()
                    .getRealPath("/upload");
            // ????????????????????????????
            try {
                String fname = photo.getFileName(); // ?????????????
                if (fname.indexOf(".") != -1) {
                    // ?????????????
                    String endWith = fname.substring(fname.lastIndexOf("."), fname.length());
                    // ????????????????????
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                    fname = sdf.format(new Date()) + endWith;
                }
                // ????��?????????????????????
                OutputStream out = new FileOutputStream(realPath + "/" + fname);
                out.write(photo.getFileData());    // ?????��????????
                out.flush();
                out.close();
                // ?????????????????
                med.setPhotoPath(fname);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        dao.saveOrUpdate(med);
        return mapping.findForward("addSuccess");
    }

    // ?????
    public ActionForward update(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // ???MedicineForm
        MedicineForm df = (MedicineForm) form;
        MedicineDao dao = new MedicineDao();
        // ??????????????????
        Medicine med = dao.loadMedicine(df.getId());
        int medCount = med.getMedCount();
        med.setMedCount(medCount + df.getMedCount());
        return mapping.findForward("addSuccess");
    }

    // ????medNo?????
    public ActionForward findMedicineByMedNo(ActionMapping mapping,
                                             ActionForm form, HttpServletRequest request,
                                             HttpServletResponse response) throws Exception {
        // ???MedicineForm
        MedicineForm df = (MedicineForm) form;
        Medicine med = null;
        // ?????
        if (df != null && df.getMedNo() != null) {
            MedicineDao dao = new MedicineDao();
            med = dao.findMedicineByMedNo(df.getMedNo());
        }
        // ??????????????????????????????
        if (med != null) {
            BeanUtils.copyProperties(df, med);
            request.setAttribute("med", "med");
            return mapping.findForward("medUpdate");
        } else {
            CategoryDao cd = new CategoryDao();
            List list = cd.findByHQL("from Category");
            request.setAttribute("cs", list);
            return mapping.findForward("medSave");
        }
    }

    // ???????????
    public ActionForward paging(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // ??????
        String currPage = request.getParameter("currPage");
        // ????action???
        String action = request.getContextPath() + "/baseData/med.do?command=paging";
        // HQL??????
        String hql = "from Medicine";
        // ????????????Map????
        Map map = this.getPage(hql, recPerPage, currPage, action, null);
        //??????????request??
        request.setAttribute("list", map.get("list"));
        //?????????????????
        request.setAttribute("pagingBar", map.get("bar"));
        return mapping.findForward("findAllSuccess");
    }

    // ??????????
    public ActionForward view(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String id = request.getParameter("id");
        Medicine med = null;
        // ????id????????
        if (id != null && !"".equals(id)) {
            MedicineDao dao = new MedicineDao();
            med = dao.loadMedicineAndCategory(Integer.parseInt(id));
        }
        request.setAttribute("med", med);
        return mapping.findForward("view");
    }

    // ???????
    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // ???MedicineForm
        MedicineForm df = (MedicineForm) form;
        Medicine med = null;
        // ????id?????
        if (df.getId() > 0) {
            MedicineDao dao = new MedicineDao();
            med = dao.loadMedicineAndCategory(df.getId());
            BeanUtils.copyProperties(df, med);
            df.setCategoryId(med.getCategory().getId());
        }
        // ?????????
        CategoryDao categoryDao = new CategoryDao();
        List cs = categoryDao.findByHQL("from Category");
        request.setAttribute("cs", cs);
        return mapping.findForward("medSave");
    }

    // ????????????????????
    public ActionForward query(ActionMapping mapping, ActionForm form,
                               HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // ???MedicineForm
        MedicineForm df = (MedicineForm) form;
        String currPage = request.getParameter("currPage");
        // ??????Action
        String action = request.getContextPath() + "/baseData/med.do?command=query";
        //????HQL??��???????
        Map mapQuery = QueryUtil.queryMedicine(df, currPage, action);
        String hql = (String) mapQuery.get("hql");
        action = (String) mapQuery.get("action");
        Object[] where = (Object[]) mapQuery.get("where");
        // ??????
        Map map = this.getPage(hql, recPerPage, currPage, action, where);
        //??????????request??
        request.setAttribute("list", map.get("list"));
        //?????????????????
        request.setAttribute("pagingBar", map.get("bar"));
        return mapping.findForward("findAllSuccess");
    }

    // ??????
    public ActionForward blurQuery(ActionMapping mapping, ActionForm form,
                                   HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // ????????
        String keyWord = request.getParameter("keyWord");
        // ???????
        String currPage = request.getParameter("currPage");
        String hql = "from Medicine d ";
        Object[] where = null;
        String action = request.getContextPath() + "/baseData/med.do?command=blurQuery";
        // ???
        if (currPage != null && !currPage.isEmpty()) {
            keyWord = StringUtil.encodeZh(keyWord);
        }
        if (keyWord != null && !keyWord.isEmpty()) {
            action += "&keyWord=" + StringUtil.encodeURL(keyWord);
            keyWord = "%" + keyWord + "%";
            hql += " where d.name like ? or d.medNo like ? or d.factoryAdd like ? or d.description like ?";
            where = new Object[]{keyWord, keyWord, keyWord, keyWord};
        }
        // ??????
        Map map = this.getPage(hql, recPerPage, currPage, action, where);
        //??????????request??
        request.setAttribute("list", map.get("list"));
        //?????????????????
        request.setAttribute("pagingBar", map.get("bar"));
        return mapping.findForward("findAllSuccess");
    }

    // ??????????
    public ActionForward canSellMeds(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // HQL???????
        String hql = "from Medicine d where d.medCount > 0";
        // ???????
        String currPage = request.getParameter("currPage");
        String action = request.getContextPath() + "/baseData/med.do?command=canSellMeds";
        // ??????
        Map map = this.getPage(hql, recPerPage, currPage, action, null);
        //??????????request??
        request.setAttribute("list", map.get("list"));
        //?????????????????
        request.setAttribute("pagingBar", map.get("bar"));
        return mapping.findForward("canSellMeds");
    }

    // ??????
    public ActionForward QueryMedCount(ActionMapping mapping, ActionForm form,
                                       HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // ??????????
        String count = request.getParameter("count");
        // ???????????>??<??=??
        String type = request.getParameter("type");
        // ???????
        String currPage = request.getParameter("currPage");
        Object[] where = null;
        String hql = "from Medicine d";
        String action = request.getContextPath() + "/require/require.do?command=blurQuery";
        if (count != null && type != null) {
            // ????????
            if (type.equals("0")) {
                hql = "from Medicine d where d.medCount = ?";
            } else if (type.equals("1")) {
                hql = "from Medicine d where d.medCount > ?";
            } else if (type.equals("-1")) {
                hql = "from Medicine d where d.medCount < ?";
            }
            action = action + "&type=" + type + "&count=" + count;
            where = new Object[]{new Integer(count)};
        }
        // ??????
        Map map = this.getPage(hql, recPerPage, currPage, action, where);
        //??????????request??
        request.setAttribute("list", map.get("list"));
        //?????????????????
        request.setAttribute("pagingBar", map.get("bar"));
        return mapping.findForward("findAllSuccess");
    }
}
