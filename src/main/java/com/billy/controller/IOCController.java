package com.billy.controller;

import com.ioc.profile.EnableProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableProfile
@RestController
@RequestMapping("/ioc")
public class IOCController {

    @Qualifier("profile")
    @Autowired
    String profile;

    @GetMapping("/profile")
    public void profile() {
        System.out.println("profile is " + profile);
    }
}
