package com.ego.upload.service.impl;

import com.ego.upload.controller.UploadController;
import com.ego.upload.service.UploadService;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Service
public class UploadServiceImpl implements UploadService {


  //注入文件上传的方法
  @Resource
  private FastFileStorageClient fileStorageClient;

  //定义处理的文件后缀类型
  private static final List<String> suffix = Arrays.asList("jpg","png","image/jpeg");
  @Override
  public String uploadFile(MultipartFile file) throws IOException {

    try {
      String contentType = file.getContentType();
      //判断文件类型是否符合
      if(!suffix.contains(contentType)){
        return null;
      }

      //判断文件是否是图片
      BufferedImage read = ImageIO.read(file.getInputStream());
      if(read==null){

        return null;
      }

      //文件上传后返回地址处理
      String afterLast = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
      StorePath storePath = fileStorageClient.uploadFile(file.getInputStream(), file.getSize(), afterLast, null);
      return "http://image.ego.com/" + storePath.getFullPath();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
