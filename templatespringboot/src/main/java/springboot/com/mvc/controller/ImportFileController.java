package springboot.com.mvc.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import springboot.com.mvc.service.ImportFileService;
import springboot.template.mvc.controller.BaseController;

import javax.annotation.Resource;

/**
 * @author HUGH
 * @Date 2019/1/9 21:53
 * @Description ImportFileController
 */
@Controller
@RequestMapping("/pro/import")
@Api("文件导入")
public class ImportFileController extends BaseController {
    @Resource
    private ImportFileService importFileService;

    @RequestMapping("list")
    public String list() {
        return PRO_IMPORT_LIST;
    }

    @RequestMapping(value = "import", method = RequestMethod.POST)
    public String importFile(@RequestParam("fileUpload") MultipartFile file) {
        if (file != null && !file.isEmpty() && file.getSize() > 0) {
            logger.info("upload file: {}  size: {}", file.getOriginalFilename(), file.getSize());
            importFileService.importFile(file);
            return INDEX;
        } else {
            return INDEX;
        }

    }
    @RequestMapping(value = "importPerson", method = RequestMethod.POST)
    public String importPerson(@RequestParam("fileUpload") MultipartFile file) {
        if (file != null && !file.isEmpty() && file.getSize() > 0) {
            logger.info("upload file: {}  size: {}", file.getOriginalFilename(), file.getSize());
            importFileService.importPerson(file);
            return INDEX;
        } else {
            return INDEX;
        }

    }
}