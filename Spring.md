## Springboot源码介绍

### SpringApplication构造(准备)阶段

重点代码

```java
public class SpringApplication {
  //    以上省略
  public SpringApplication(ResourceLoader resourceLoader, Class<?>... primarySources) {
    this.sources = new LinkedHashSet();
    this.bannerMode = Mode.CONSOLE;
    this.logStartupInfo = true;
    this.addCommandLineProperties = true;
    this.addConversionService = true;
    this.headless = true;
    this.registerShutdownHook = true;
    this.additionalProfiles = Collections.emptySet();
    this.isCustomEnvironment = false;
    this.lazyInitialization = false;
    this.applicationContextFactory = ApplicationContextFactory.DEFAULT;
    this.applicationStartup = ApplicationStartup.DEFAULT;
    this.resourceLoader = resourceLoader;
    Assert.notNull(primarySources, "PrimarySources must not be null");
    this.primarySources = new LinkedHashSet(Arrays.asList(primarySources));
    this.webApplicationType = WebApplicationType.deduceFromClasspath();
    this.bootstrappers = new ArrayList(this.getSpringFactoriesInstances(Bootstrapper.class));
    this.setInitializers(this.getSpringFactoriesInstances(ApplicationContextInitializer.class));    //加载初始化器
    this.setListeners(this.getSpringFactoriesInstances(ApplicationListener.class)); //加载事件监听器
    this.mainApplicationClass = this.deduceMainApplicationClass();  //推断引导类
  }
//    以下省略
}
```

* 配置SpringBootBean  
  xml,java配置文件集合,Springboot会读取BeanDefinitionLoader,并且将配置加载为Spring源Bean  
  Spring读取SpringApplication.run(SpringApplicationTest.class,args)中的.class作为源Bean,根据源Bean上的注解实行注入
* web应用的类型推断  
  WebApplicationType(NONE,SERVLET,REACTIVE)  
  -web应用  
  -非web应用
* 加载应用上下文初始化器  
  查看spring-boot-autoconfigure-2.4.3.jar的spring.factories中的

```bash
# Initializers
org.springframework.context.ApplicationContextInitializer=\
org.springframework.boot.autoconfigure.SharedMetadataReaderFactoryContextInitializer,\
org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener
```

* 加载事件监听器  
  查看spring-boot-autoconfigure-2.4.3.jar的spring.factories中的

```bash
# Application Listeners
org.springframework.context.ApplicationListener=\
org.springframework.boot.autoconfigure.BackgroundPreinitializer
```

* 推断引导类  
  main方法所在的类,使用堆栈获得,注意MainApplicationClass

### SpringApplication运行阶段

* 加载,运行SpringApplication运行监听器  
  D:\Program
  Files\apache-maven-3.3.9\tansun\repository\org\springframework\boot\spring-boot\2.4.3\spring-boot-2.4.3.jar!
  \org\springframework\boot\SpringApplicationRunListener.class  
  **SpringApplicationRunListener**

```java
public interface SpringApplicationRunListener {
  default void starting(ConfigurableBootstrapContext bootstrapContext) {
    this.starting();
  }//  Spring应用刚启动的时候  

  /** @deprecated */
  @Deprecated
  default void starting() {
  }

  default void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
    this.environmentPrepared(environment);
  }   //  ConfigurableEnvironment 准备完成

  /** @deprecated */
  @Deprecated
  default void environmentPrepared(ConfigurableEnvironment environment) {
  }

  default void contextPrepared(ConfigurableApplicationContext context) {
  }   //  ConfigurableEnvironment准备好允许调整 

  default void contextLoaded(ConfigurableApplicationContext context) {
  }   //  已加载未启动  

  default void started(ConfigurableApplicationContext context) {
  }   //  Bean初始化完成  

  default void running(ConfigurableApplicationContext context) {
  }   //  应用运行  

  default void failed(ConfigurableApplicationContext context, Throwable exception) {
  }   //  应用运行失败
}
```

* 监听Springboot事件  
  监听器可见音乐圣经消息事件机制,注意实际上监听器可设置order

* 创建Spring应用上下文,Environment对象  
