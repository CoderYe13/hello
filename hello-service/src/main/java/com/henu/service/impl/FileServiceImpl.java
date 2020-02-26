package com.henu.service.impl;

import com.henu.service.IFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;


@Service
public class FileServiceImpl implements IFileService {
    @Override
    public boolean uploads(MultipartFile [] multipartFile, String contextPath) {
        String filePath = contextPath;
        File fileDir = new File(filePath);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String originalFilename;
        try {
            for(int i=0;i<multipartFile.length;i++){
                originalFilename= multipartFile[i].getOriginalFilename();
                inputStream = multipartFile[i].getInputStream();
                outputStream = new FileOutputStream(filePath + File.separator + originalFilename, true);
                byte[] data = new byte[1024];
                int len ;
                while ((len = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, len);
                }
                inputStream=null;
                outputStream=null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (inputStream!=null){
                    inputStream.close();
                }
                if (outputStream!=null){
                    outputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean upload(MultipartFile multipartFile, String contextPath) {
        String filePath = contextPath;
        File fileDir = new File(filePath);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
                String originalFilename = multipartFile.getOriginalFilename();
                inputStream = multipartFile.getInputStream();
                outputStream = new FileOutputStream(filePath + File.separator + originalFilename, true);
                byte[] data = new byte[1024];
                int len ;
                while ((len = inputStream.read(data)) != -1) {
                    outputStream.write(data, 0, len);
                }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (inputStream!=null){
                    inputStream.close();
                }
               if (outputStream!=null){
                   outputStream.close();
               }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return true;
    }


    @Override
    public boolean download(String filePath) {
        File file=new File(filePath);
        return file.exists();
    }
}
