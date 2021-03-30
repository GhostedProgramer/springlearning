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
 * Mybatis-plus 主数据源ds2配置
 * 多数据源配置依赖数据源配置
 * @see DataSourceConfig
 */
@Configuration
@MapperScan(
    basePackages = ["com.billy.mp4doubleds.model.ds2", "com.billy.mp4doubleds.mapper.ds2"],
    sqlSessionTemplateRef = "ds2SqlSessionTemplate"
)
open class MybatisPlusConfig4ds2 {
    //ds2数据源
//    @Primary
    @Bean("ds2SqlSessionFactory")
    @Throws(Exception::class)
    open fun ds2SqlSessionFactory(@Qualifier("ds2DataSource") dataSource: DataSource?): SqlSessionFactory {
        val sqlSessionFactory = MybatisSqlSessionFactoryBean()
        sqlSessionFactory.setDataSource(dataSource)
        val configuration = MybatisConfiguration()
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver::class.java)
        configuration.jdbcTypeForNull = JdbcType.NULL
        sqlSessionFactory.setConfiguration(configuration)
        sqlSessionFactory.setMapperLocations(PathMatchingResourcePatternResolver().getResources("classpath*:mapper/ds2/**/*.xml"))
        sqlSessionFactory.setPlugins(
            arrayOf(
                PaginationInterceptor(),
                PerformanceInterceptor() //                        .setFormat(true),
            )
        )
        sqlSessionFactory.setGlobalConfig(GlobalConfig().setBanner(false))
        return sqlSessionFactory.getObject()
    }

    //    @Primary
    @Bean(name = ["ds2TransactionManager"])
    open fun ds2TransactionManager(@Qualifier("ds2DataSource") dataSource: DataSource?): DataSourceTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }

    //    @Primary
    @Bean(name = ["ds2SqlSessionTemplate"])
    open fun ds2SqlSessionTemplate(@Qualifier("ds2SqlSessionFactory") sqlSessionFactory: SqlSessionFactory?): SqlSessionTemplate {
        return SqlSessionTemplate(sqlSessionFactory)
    }
}

