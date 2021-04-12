//package com.billy.mp4doubleds.controller
//
//import com.billy.mp4doubleds.model.User
//import com.billy.mp4doubleds.model.Account
//import com.billy.mp4doubleds.service.AccountService
//import com.billy.mp4doubleds.service.UserService
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.web.bind.annotation.GetMapping
//import org.springframework.web.bind.annotation.RestController
//
//@RestController
//class TestMpDoubleDsController(
//    @Autowired val userService: UserService,
//    @Autowired val accountService: AccountService
//) {
//
//    @GetMapping("/create")
//    fun test() {
//        val user = User().apply {
//            this.username = "name1"
//            this.password = "password1"
//        }
//        userService.create(user)
//    }
//
//    @GetMapping("/create1")
//    fun test1() {
//        val account = Account().apply {
//            this.no = "1415926"
//        }
//        accountService.create(account)
//    }
//}