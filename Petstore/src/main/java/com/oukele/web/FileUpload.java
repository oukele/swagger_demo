package com.oukele.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(path = "/imgUpload")
public class FileUpload {

    /*
     * 宠物图片上传
     * */
    @PostMapping(produces = "application/json;charset=utf-8")
    @ResponseBody
    public String imgUpload(@RequestPart("filename") MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response){
        if (multipartFile.isEmpty()) {
            return "{\"error\":\"文件为空，错误格式\"}";
        }
        if (!multipartFile.getContentType().contains("image/")) {
            return "{\"error\":\"只允许上传图片的文件\"}";
        }
        if (multipartFile.getSize() > 1024 * 1024 * 1024 * 5) {
            return "{\"error\":\"图片大小不能超过5M\"}";
        }
        //图片的存储文件夹
        String save = request.getServletContext().getRealPath("/images");
        File file = new File(save);
        if (!file.exists()) {
            file.mkdirs();
        }
        String file1 = createFile(save, multipartFile);

        return file1;
    }
    //创建文件夹，格式为以日期文件名 比如 2018112 , 和 新的文件名，格式为 upload_文件名_日期.后缀名
    public String createFile(String path, MultipartFile multipartFile) {
        boolean flag = false;
        String imgpath ="";
        //创建文件夹
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String dataFile = "/" + simpleDateFormat.format(new Date());
        path += dataFile;
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        //文件名
        String fileName = multipartFile.getOriginalFilename().substring(0, multipartFile.getOriginalFilename().indexOf("."));
        //上传文件的后缀
        String zhui = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf("."), multipartFile.getOriginalFilename().length());
        //生成新的文件名
        String fileNewName = "upload_" + fileName + "_" + simpleDateFormat.format(new Date()) + zhui;
        try {
            //将此图片存储到对应的文件夹中
            multipartFile.transferTo(new File(path + "/" + fileNewName));
             imgpath ="/images"+dataFile+"/"+ fileNewName;
            flag = true;
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        if( flag ){
            return "{\"img_src\":\""+imgpath+"\"}";
        }

        return "{\"error\":\"出现异常\"}";
    }


}
