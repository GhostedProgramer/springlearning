package com.ioc.profile

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Profile("local")
@Configuration
open class ProfileModule {

    @Bean
    open fun profile(): String {
        return "profile"
    }
}