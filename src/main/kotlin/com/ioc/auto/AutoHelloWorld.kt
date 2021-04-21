package com.ioc.auto

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AutoHelloWorld {

    @Bean
    open fun autoHello(): String {
        return "auto Hello"
    }
}