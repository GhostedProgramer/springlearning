package com.billy.controller;


import com.billy.ioc.TestBeanIOC;
import com.billy.ioc.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    final TestBeanIOC testBeanIOC;

    final ApplicationContext context;

    public TestController(TestBeanIOC testBeanIOC, ApplicationContext context) {
        this.testBeanIOC = testBeanIOC;
        this.context = context;
    }

    @GetMapping("/test")
    public void test() {
        testBeanIOC.test();
        Person person = (Person) context.getBean("person1");
        System.out.println("person get by ApplicationContext is " + person);
    }

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @GetMapping("/hi")
    public String hi() {
        System.out.println("hi");
        return "hi";
    }
}
