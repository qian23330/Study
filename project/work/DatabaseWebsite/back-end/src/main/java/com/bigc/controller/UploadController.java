package com.bigc.controller;

import com.bigc.pojo.Result;
import com.bigc.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile doc) throws Exception {
        log.info("文件上传，文件名:{}", doc.getOriginalFilename());

        // 调用阿里云OSS工具类进行文件上传
        String url = aliOSSUtils.upload(doc);
        log.info("文件上传成功，文件访问的url:{}", url);

        return Result.success(url);
    }
}
