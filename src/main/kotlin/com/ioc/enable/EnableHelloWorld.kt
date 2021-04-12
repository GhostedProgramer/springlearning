package com.ioc.enable

import org.springframework.context.annotation.Import

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(HelloWorldModule::class)
annotation class EnableHelloWorld
