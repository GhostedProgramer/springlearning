package com.billy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Value(value = "${file.path}")
    private String filePath;

    @PostMapping(value = "fileUpload")
    public void fileUpload(HttpServletRequest request, @RequestParam(value = "file") MultipartFile multipartFile) {
        if (multipartFile != null) {
            String newFileName = multipartFile.getOriginalFilename();
            System.out.println(filePath);
            File file = new File(filePath + newFileName);
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
