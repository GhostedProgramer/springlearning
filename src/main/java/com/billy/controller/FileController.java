package com.billy.controller;

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

    @PostMapping(value = "fileUpload")
    public void fileUpload(HttpServletRequest request, @RequestParam(value = "file") MultipartFile multipartFile) {
        if (multipartFile != null) {
            String path = "D:\\document\\code\\IDEA\\learning\\springlearning\\src\\main\\resources\\file\\";
            String newFileName = multipartFile.getOriginalFilename();
            File file = new File(path + newFileName);
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
