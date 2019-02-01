package springboot.com.mvc.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author HUGH
 * @Date 2019/1/9 22:43
 * @Description ImportFileService
 */
public interface ImportFileService {


    /**
     * 上传文件处理
     *
     * @param uploadfile
     */
    void importFile(MultipartFile uploadfile);
}
