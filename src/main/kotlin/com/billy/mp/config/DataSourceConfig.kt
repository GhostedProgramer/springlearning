//package com.billy.mp.config
//
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver
//
//import org.mybatis.spring.SqlSessionFactoryBean
//
//import org.springframework.jdbc.datasource.DataSourceTransactionManager
//
//import com.alibaba.druid.pool.DruidDataSource
//import org.springframework.beans.factory.annotation.Value
//
//import org.springframework.beans.factory.config.PropertiesFactoryBean
//import org.springframework.context.annotation.Bean
//
//import org.springframework.context.annotation.ComponentScan
//import org.springframework.context.annotation.Configuration
//import java.lang.Exception
//
//
//@Configuration
//@ComponentScan(basePackages = ["com.gitee.sunchenbin.mybatis.actable.manager.*"])
//open class DataSourceConfig {
//    @Value("\${spring.datasource.driver-class-name}")
//    private val driver: String? = null
//
//    @Value("\${spring.datasource.url}")
//    private val url: String? = null
//
//    @Value("\${spring.datasource.username}")
//    private val username: String? = null
//
//    @Value("\${spring.datasource.password}")
//    private val password: String? = null
//
//    @Bean
//    open fun dataSource(): DruidDataSource {
//        val dataSource = DruidDataSource()
//        dataSource.driverClassName = driver
//        dataSource.url = url
//        dataSource.username = username
//        dataSource.password = password
//        dataSource.maxActive = 30
//        dataSource.initialSize = 10
//        dataSource.validationQuery = "SELECT 1"
//        dataSource.isTestOnBorrow = true
//        return dataSource
//    }
//
//    @Bean
//    open fun dataSourceTransactionManager(): DataSourceTransactionManager {
//        val dataSourceTransactionManager = DataSourceTransactionManager()
//        dataSourceTransactionManager.dataSource = dataSource()
//        return dataSourceTransactionManager
//    }
//
//    @Bean
//    @Throws(Exception::class)
//    open fun sqlSessionFactory(): SqlSessionFactoryBean {
//        val sqlSessionFactoryBean = SqlSessionFactoryBean()
//        sqlSessionFactoryBean.setDataSource(dataSource())
//        val resolver = PathMatchingResourcePatternResolver()
//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:com/gitee/sunchenbin/mybatis/actable/mapping/*/*.xml"))
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.billy.mp.model.*") //设置别名为了在mapper文件中无需写全包路径
//        return sqlSessionFactoryBean
//    }
//}
