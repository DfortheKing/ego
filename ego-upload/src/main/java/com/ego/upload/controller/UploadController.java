package com.ego.upload.controller;

import com.ego.upload.service.UploadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadController {

  @Resource
  private UploadService uploadService;
  //文件上传
  @PostMapping("/image")
  public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
    if(file==null){
      return ResponseEntity.badRequest().build();
    }
    String url = uploadService.uploadFile(file);
    return ResponseEntity.ok(url);
  }
}
