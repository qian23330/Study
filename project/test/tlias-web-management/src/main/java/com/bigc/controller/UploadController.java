package com.bigc.controller;

import com.bigc.pojo.Result;
import com.bigc.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传Controller
 */
@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    // 本地存储文件方式
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
//        log.info("文件上传：{},{},{}", username, age, image);
//        // 获取原始文件名
//        String originalFilename = image.getOriginalFilename();
//
//        // 构造唯一文件名 - uuid(通用唯一识别码)
//        assert originalFilename != null;
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID().toString() + extname;
//        log.info("新文件名：{}", newFileName);
//
//        // 将接受的文件进行存储
//        image.transferTo(new File("/Users/qianlong/Git/Study/project/test/tlias-web-management/src/main/resources/static/image/" + newFileName));
//
//        return Result.success();
//    }

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception {
        log.info("文件上传，文件名:{}", image.getOriginalFilename());

        // 调用阿里云OSS工具类进行文件上传
        String url = aliOSSUtils.upload(image);
        log.info("文件上传成功，文件访问的url:{}", url);

        return Result.success(url);
    }
}
