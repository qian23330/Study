package com.bigc.controller;

import com.bigc.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
        log.info("文件上传：{},{},{}", username, age, image);
        // 获取原始文件名
        String originalFilename = image.getOriginalFilename();
        // 将接受的文件进行存储
        image.transferTo(new File("/Users/qianlong/Git/Study/project/test/tlias-web-management/src/main/resources/static/image/" + originalFilename));
        return Result.success();
    }
}
