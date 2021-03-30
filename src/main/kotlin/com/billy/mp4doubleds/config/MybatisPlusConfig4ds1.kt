package com.billy.mp4doubleds.config

import org.mybatis.spring.SqlSessionTemplate

import org.apache.ibatis.session.SqlSessionFactory

import org.springframework.beans.factory.annotation.Qualifier

import org.springframework.context.annotation.Primary

import org.springframework.jdbc.datasource.DataSourceTransactionManager

import com.baomidou.mybatisplus.core.config.GlobalConfig

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor

import org.springframework.core.io.support.PathMatchingResourcePatternResolver

import org.apache.ibatis.type.JdbcType

import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver

import com.baomidou.mybatisplus.core.MybatisConfiguration

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean

import org.mybatis.spring.annotation.MapperScan

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.lang.Exception
import javax.sql.DataSource


/**
 * Mybatis-plus 主数据源ds1配置
 * 多数据源配置依赖数据源配置
 * @see DataSourceConfig
 */
@Configuration
@MapperScan(
    basePackages = ["com.billy.mp4doubleds.model.ds1", "com.billy.mp4doubleds.mapper.ds1"],
    sqlSessionTemplateRef = "ds1SqlSessionTemplate"
)
open class MybatisPlusConfig4ds1 {
    //主数据源 ds1数据源
    @Primary
    @Bean("ds1SqlSessionFactory")
    @Throws(Exception::class)
    open fun ds1SqlSessionFactory(@Qualifier("ds1DataSource") dataSource: DataSource?): SqlSessionFactory {
        val sqlSessionFactory = MybatisSqlSessionFactoryBean()
        sqlSessionFactory.setDataSource(dataSource)
        val configuration = MybatisConfiguration()
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver::class.java)
        configuration.jdbcTypeForNull = JdbcType.NULL
        sqlSessionFactory.setConfiguration(configuration)
        sqlSessionFactory.setMapperLocations(PathMatchingResourcePatternResolver().getResources("classpath*:mapper/ds1/**/*.xml"))
        sqlSessionFactory.setPlugins(
            arrayOf(
                PaginationInterceptor(),
                PerformanceInterceptor() //                        .setFormat(true),
            )
        )
        sqlSessionFactory.setGlobalConfig(GlobalConfig().setBanner(false))
        return sqlSessionFactory.getObject()
    }

    @Primary
    @Bean(name = ["ds1TransactionManager"])
    open fun ds1TransactionManager(@Qualifier("ds1DataSource") dataSource: DataSource?): DataSourceTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }

    @Primary
    @Bean(name = ["ds1SqlSessionTemplate"])
    open fun ds1SqlSessionTemplate(@Qualifier("ds1SqlSessionFactory") sqlSessionFactory: SqlSessionFactory?): SqlSessionTemplate {
        return SqlSessionTemplate(sqlSessionFactory)
    }
}

