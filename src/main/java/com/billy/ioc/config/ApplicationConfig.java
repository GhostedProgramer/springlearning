package com.billy.ioc.config;

import com.billy.ioc.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用@Configuration类结合@Bean方法装配Bean,如再@Bean注解中不显示指定name,则以方法名为bean的name名
 */
@Configuration
public class ApplicationConfig {

    @Bean(name = "person1")
    public Person initPerson1() {
        Person person = new Person();
        person.setId(1L);
        person.setName("person1");
        return person;
    }

    @Bean(name = "person2")
    public Person initPerson2() {
        Person person = new Person();
        person.setId(2L);
        person.setName("person2");
        return person;
    }
}
