package com.xmmems.service;

import com.xmmems.common.constant.XmmemsConstants;
import com.xmmems.common.exception.ExceptionEnum;
import com.xmmems.common.exception.XMException;
import com.xmmems.domain.Upload;
import com.xmmems.mapper.UploadMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @描述
 * @创建人 ithxw
 * @创建时间 2020.03.19 16:54
 */
@Service
@Transactional
@Slf4j
public class UploadService {

    private static final List<String> ALLOW_IMAGE = Arrays.asList("image/jpeg", "image/png");
    private static final List<String> ALLOW_FILE = Arrays.asList("application/pdf", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");

    @Autowired
    private UploadMapper uploadMapper;

    /**
     * 是否允许图片上传
     */
    private boolean isUploadImg(MultipartFile file, String contentType) {
        //判断当前文件的mine类型是否属于允许的类型
        if (!ALLOW_IMAGE.contains(contentType)) return false;

        //解析文件流，查看是否是真的图片
        BufferedImage read = null;
        try {
            read = ImageIO.read(file.getInputStream());
        } catch (IOException e) {
            return false;
        }
        if (read == null) return false;
        return true;
    }

    /**
     * 是否允许文件上传
     */
    private boolean isUploadFile(MultipartFile file, String contentType) {
        //判断当前文件的mine类型是否属于允许的类型
        if (!ALLOW_FILE.contains(contentType)) return false;

        //解析文件流，查看是否是真的图片
        /*BufferedImage read = null;
        try {
            read = ImageIO.read(file.getInputStream());
        } catch (IOException e) {
            return false;
        }
        if (read == null)
            return false;*/
        return true;
    }

    /**
     * 上传图片或文件
     *
     * @return 上传后对应的文件名称
     */
    private String uploadToLocal(MultipartFile file, String uploadPath) {
        File pathFile = new File(uploadPath);
        //创建文件在服务器的名称
        String fileName = UUID.randomUUID() + file.getOriginalFilename();
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        //上传文件到本地的api
        try {
            file.transferTo(new File(pathFile, fileName));
        } catch (IOException e) {
            throw new XMException(500, e.getMessage());
        }
        return fileName;
    }

    /**
     * 背景图片上传
     *
     * @param file
     * @return 图片url路径
     */
    public String background(MultipartFile file) {
        //得到当前文件类型
        String contentType = file.getContentType();
        //是否允许上传
        boolean upload = isUploadImg(file, contentType);
        if (!upload)
            throw new XMException(ExceptionEnum.INVALID_FILE_TYPE);

        double size = file.getSize() / 1024d; //kb
        if (size > 2048 || size < 10)  //判断图片大小 单位Kb
            throw new XMException(500, "图片尺寸不合适.范围10kb - 2048kb");

        //指定文件上传的文件夹
        String fileName = uploadToLocal(file, XmmemsConstants.UPLOAD_IMG_PATH);
        //文件上传失误
        if (fileName == null)
            throw new XMException(ExceptionEnum.FILE_UPLOAD_ERROR);

        String url = XmmemsConstants.UPLOAD_IMG_URL + fileName;

        Upload record = new Upload();
        record.setDate(new Date());
        record.setUrl(url);
        record.setSize(size);
        record.setPurpose("背景图片");
        record.setType("image");
        record.setIsValid(1);
        record.setName(file.getOriginalFilename());

        int i = uploadMapper.insertSelective(record);
        if (i < 1) throw new XMException(ExceptionEnum.FILE_UPLOAD_ERROR);
        return url;
    }

    /**
     * 查找背景图片
     *
     * @return 路径
     */
    public String findBackground() {
        String url = uploadMapper.selectNewestBackground();
        if (StringUtils.isBlank(url)) {
            return null;
        }
        return url;
    }

    /**
     * 上传附录文件
     *
     * @param file
     * @return
     */
    public String file(MultipartFile file) {
        //得到当前文件类型
        String contentType = file.getContentType();

        //是否允许上传
        boolean uploadFile = isUploadFile(file, contentType);
        if (!uploadFile) {
            throw new XMException(ExceptionEnum.INVALID_FILE_TYPE);
        }

        //文件大小
        double size = file.getSize() / 1024d;
        if (size > 1024 * 5) {
            throw new XMException(500, "文件大小不合适，不能超过5M");
        }

        //指定文件上传的文件夹
        String fileName = uploadToLocal(file, XmmemsConstants.UPLOAD_FILE_PATH);
        //保存文件
        if (fileName == null) {
            throw new XMException(ExceptionEnum.FILE_UPLOAD_ERROR);
        }
        String url = XmmemsConstants.UPLOAD_FILE_URL + fileName;
        return url;
    }

    public List<Upload> findFiles() {
        return uploadMapper.selectAllFiles();
    }
}
