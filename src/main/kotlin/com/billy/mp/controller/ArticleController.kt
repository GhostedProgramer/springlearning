//package com.billy.mp.controller
//
//import com.billy.mp.service.ArticleService
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.RestController
//
//@RestController
//class ArticleController(
//    @Autowired val articleService: ArticleService
//) {
//
//    @GetMapping("/selectArticleCount")
//    fun selectArticleCount(): Int {
//        return articleService.selectArticleCount()
//    }
//
//    @GetMapping("/selectPage")
//    fun selectPage(): String {
//        return articleService.selectPage().toString()
//    }
//}