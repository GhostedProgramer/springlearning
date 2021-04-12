package com.ioc.enable

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class HelloWorldModule {

    @Bean
    open fun hello(): String {
        return "hello"
    }

    @Bean
    open fun world(): String {
        return "world"
    }
}