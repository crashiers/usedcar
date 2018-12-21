package com.cn.jhsoft.usedcar.common.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ThumbnailUtils {

    public String thumbnail(MultipartFile file, String uploadPath, String fileName, String url, int width, int height) {
        String smallName = fileName + "." + width + fileName.substring(fileName.lastIndexOf("."));
        try {
            String des = uploadPath +"/" + smallName;
            Thumbnails.of(file.getInputStream()).size(width, height).toFile(des); ;
        } catch(Exception e) {
            e.printStackTrace() ;
        }
        return url + "/" + smallName ;
    }
}