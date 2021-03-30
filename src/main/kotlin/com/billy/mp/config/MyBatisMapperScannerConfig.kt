//package com.billy.mp.config
//
//import org.mybatis.spring.mapper.MapperScannerConfigurer
//import org.springframework.boot.autoconfigure.AutoConfigureAfter
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//
//@Configuration
//@AutoConfigureAfter(value = [DataSourceConfig::class])
//open class MyBatisMapperScannerConfig {
//    @Bean
//    open fun mapperScannerConfigurer(): MapperScannerConfigurer {
//        val mapperScannerConfigurer = MapperScannerConfigurer()
//        mapperScannerConfigurer.setBasePackage("com.blog.table.mapper.*;com.gitee.sunchenbin.mybatis.actable.dao.*")
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory")
//        return mapperScannerConfigurer
//    }
//}