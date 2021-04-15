package com.billy.ioc.controller

import com.billy.ioc.conditionbean.TestModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ioc")
class TestIocController(
    @Autowired val testModel: TestModel
) {

    @GetMapping("/missing")
    fun conditionalOnMissingBean() {
        println(testModel.eat())
    }
}