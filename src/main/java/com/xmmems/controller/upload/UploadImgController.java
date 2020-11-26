package com.xmmems.controller.upload;

import com.xmmems.domain.Upload;
import com.xmmems.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @描述  本地上传图片控制层
 * @创建人 ithxw
 * @创建时间 2020.03.19 16:52
 */
@RestController
@RequestMapping("/upload")
public class UploadImgController {

    @Autowired
    private UploadService uploadService;

    /**
     * 图片上传
     * @param file
     * @author: ithxw
     * @Date: 2020/3/20
     * @return: org.springframework.http.ResponseEntity<java.lang.String>
     */
  /*  @PostMapping("/image")
    public ResponseEntity<String> uploadImage(MultipartFile file) {
        String url = uploadService.uploadImage(file);
        return ResponseEntity.ok(url);
    }*/

    /**
     * 背景图片上传
     * @param file
     * @return 背景图片路径
     */
    @PostMapping("/background")
    public ResponseEntity<String> background(MultipartFile file) {
        String url = uploadService.background(file);
        return ResponseEntity.ok(url);
    }

    /**
     * 查找背景图片路径
     * @return 背景图片路径
     */
    @PostMapping("/findBackground")
    public ResponseEntity<String> findBackground() {
        String url = uploadService.findBackground();
        return ResponseEntity.ok(url);
    }
/**
 * 上传附件
 * @param file
 * @author: ithxw
 * @Date: 2020/3/20
 * @return: org.springframework.http.ResponseEntity<java.lang.String>
 */
    @PostMapping("/file")
    public ResponseEntity<String> file(MultipartFile file){
        String url = uploadService.file(file);
        return ResponseEntity.ok(url);

    }

    @PostMapping("/findFiles")
    public ResponseEntity<List<Upload>> findFiles(){

        List<Upload> url = uploadService.findFiles();
        return ResponseEntity.ok(url);
    }

}
