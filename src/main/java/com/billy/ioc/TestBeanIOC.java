package com.billy.ioc;

import com.billy.ioc.entity.Person;
import org.springframework.stereotype.Service;

@Service
public class TestBeanIOC {

    final Person person1;

    final Person person2;

    public TestBeanIOC(Person person1, Person person2) {
        this.person1 = person1;
        this.person2 = person2;
    }

    public void test() {
        System.out.println("person1 is " + person1);
        System.out.println("person2 is " + person2);
    }
}
