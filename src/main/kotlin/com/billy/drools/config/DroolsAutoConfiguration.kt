package com.billy.drools.config

import org.springframework.context.annotation.Configuration
import org.kie.api.builder.KieFileSystem
import org.kie.internal.io.ResourceFactory
import java.io.IOException
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.core.io.Resource
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.core.io.support.ResourcePatternResolver
import org.kie.spring.KModuleBeanFactoryPostProcessor
import org.kie.api.runtime.KieSession
import org.kie.api.KieBase
import org.kie.api.KieServices
import org.kie.api.runtime.KieContainer
import org.slf4j.LoggerFactory


@Configuration
open class DroolsAutoConfiguration {
    private val RULEPATH = "rules/"
    private val logger = LoggerFactory.getLogger(DroolsAutoConfiguration::class.java)

    @Bean
    @ConditionalOnMissingBean(KieFileSystem::class)
    @Throws(IOException::class)
    open fun kieFileSystem(): KieFileSystem {
        val kieFileSystem: KieFileSystem = getKieServices().newKieFileSystem()
        for (file in getRuleFiles()!!) {
            if (file != null) {
                kieFileSystem.write(ResourceFactory.newClassPathResource(RULEPATH + file.filename, "UTF-8"))
            }
        }
        return kieFileSystem
    }

    @Throws(IOException::class)
    private fun getRuleFiles(): Array<Resource?>? {
        val resourcePatternResolver: ResourcePatternResolver = PathMatchingResourcePatternResolver()
        return resourcePatternResolver.getResources("classpath*:$RULEPATH**/*.*")
    }


    @Bean
    @ConditionalOnMissingBean(KieContainer::class)
    @Throws(IOException::class)
    open fun kieContainer(): KieContainer {
        val kieRepository = getKieServices().repository
        kieRepository.addKieModule { kieRepository.defaultReleaseId }
        getKieServices().newKieBuilder(kieFileSystem()).buildAll()
        return getKieServices().newKieContainer(kieRepository.defaultReleaseId)
    }

    private fun getKieServices(): KieServices {
        return KieServices.Factory.get()
    }

    @Bean
    @ConditionalOnMissingBean(KieBase::class)
    @Throws(IOException::class)
    open fun kieBase(): KieBase? {
        return kieContainer().kieBase
    }

    // 不能反复被使用，释放资源后需要重新获取。
    // @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    @ConditionalOnMissingBean(KieSession::class)
    @Throws(IOException::class)
    open fun kieSession(): KieSession? {
        return kieContainer().newKieSession()
    }

    @Bean
    @ConditionalOnMissingBean(KModuleBeanFactoryPostProcessor::class)
    open fun kiePostProcessor(): KModuleBeanFactoryPostProcessor? {
        return KModuleBeanFactoryPostProcessor()
    }
}