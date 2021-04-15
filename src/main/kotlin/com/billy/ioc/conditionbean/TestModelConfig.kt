package com.billy.ioc.conditionbean

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class TestModelConfig {

    @Bean
    @ConditionalOnMissingBean
    open fun testModel(): TestModel {
        return TestModelImpl1()
    }

}