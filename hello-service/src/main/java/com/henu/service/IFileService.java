package com.henu.service;

import org.springframework.web.multipart.MultipartFile;


public interface IFileService {
    boolean uploads(MultipartFile[] multipartFile, String contextPath);
    boolean upload(MultipartFile multipartFile, String contextPath);
    boolean download(String filePath);
}
