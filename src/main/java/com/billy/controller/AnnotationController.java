package com.billy.controller;

import com.billy.annotation.NeedApprove;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/annotation")
public class AnnotationController {

    @NeedApprove
    @GetMapping("/test")
    public void test() {
        System.out.println("begin test");
    }

    @GetMapping("/test2")
    public void test2() {
        System.out.println("begin test2");
    }
}
