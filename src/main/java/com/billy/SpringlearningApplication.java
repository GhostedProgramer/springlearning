package com.billy;

import com.ioc.enable.EnableHelloWorld;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 使用ApplicationContext可以获取Spring BeanFactory中装载到的所有类
 * Spring体系中有两种方式装载Bean,一种是通过@Configuration类中的@Bean方法注解,另外一种是通过@Component注解
 */
@EnableHelloWorld
@SpringBootApplication
public class SpringlearningApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringlearningApplication.class, args);
//        Person person = (Person) context.getBean("person1");
//        System.out.println(person);
//        Person personComponent = context.getBean("personComponent", Person.class);
//        System.out.println(personComponent);
//        System.out.println(context.getBean("hello", String.class));
//        System.out.println(context.getBean("world", String.class));
        System.out.println(context.getBean("autoHello", String.class));
    }

}
