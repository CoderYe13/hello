package com.henu.web.controller;

import com.henu.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@Controller
public class FileUploadController {

    @Autowired
    IFileService fileService;

    @RequestMapping("/file/upload")
    @ResponseBody
    public String fileUpload(HttpServletRequest request, @RequestParam(value = "upload_file", required = false) MultipartFile files) {
        String contextPath = request.getSession().getServletContext().getRealPath("uploads");
        if (fileService.upload(files, contextPath)) {
            return "uploadOk";
        } else {
            return "uploadFail";
        }
    }

    @RequestMapping("/file/uploads")
    @ResponseBody
    public String fileUploads(HttpServletRequest request, @RequestParam(value = "upload_file", required = false) MultipartFile[] files) {
        String contextPath = request.getSession().getServletContext().getRealPath("uploads");
        if (fileService.uploads(files, contextPath)) {
            return "uploadOk";
        } else {
            return "uploadFail";
        }
    }

    @RequestMapping("/file/download")
    @ResponseBody
    public String fileDownload(HttpServletRequest request, HttpServletResponse response) {
        String contextPath = request.getSession().getServletContext().getRealPath("uploads");
        String filePath = contextPath + File.separator+"t01b2ead60f64b0a608.jpg";
        if(fileService.download(filePath)){
            try {
                File file = new File(filePath);
                String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);//得到文件名
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");//把文件名按UTF-8取出并按ISO8859-1编码，保证弹出窗口中的文件名中文不乱码，中文不要太多，最多支持17个中文，因为header有150个字节限制。
                response.setContentType("application/octet-stream");//告诉浏览器输出内容为流
                response.addHeader("Content-Disposition", "attachment;filename=" + fileName);//Content-Disposition中指定的类型是文件的扩展名，并且弹出的下载对话框中的文件类型图片是按照文件的扩展名显示的，点保存后，文件以filename的值命名，保存类型以Content中设置的为准。注意：在设置Content-Disposition头字段之前，一定要设置Content-Type头字段。
                String len = String.valueOf(file.length());
                response.setHeader("Content-Length", len);//设置内容长度
                OutputStream out = response.getOutputStream();
                FileInputStream in = new FileInputStream(file);
                byte[] b = new byte[1024];
                int n;
                while ((n = in.read(b)) != -1) {
                    out.write(b, 0, n);
                }
                in.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
                return "downloadFail";
            }
        }
        return "downloadOK";
    }
}
