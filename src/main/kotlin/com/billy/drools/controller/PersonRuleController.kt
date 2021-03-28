package com.billy.drools.controller

import com.billy.drools.model.Person
import org.kie.api.runtime.KieContainer
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("rule/person")
class PersonRuleController(
    @Autowired val kieContainer: KieContainer
) {

    private val logger = LoggerFactory.getLogger(PersonRuleController::class.java)

    @PostMapping("/one")
    fun fireAllRules4One(@RequestBody person: Person) {
        val newKieSession = kieContainer.newKieSession()
        try {
            newKieSession.insert(person)
            newKieSession.fireAllRules()
        } finally {
            newKieSession.dispose()
        }
    }

    @PostMapping("/list")
    fun fireAllRules4List(@RequestBody persons: List<Person>) {
        val newKieSession = kieContainer.newKieSession()
        try {
            persons.forEach {
                newKieSession.insert(it)
            }
            newKieSession.fireAllRules()
        } finally {
            newKieSession.dispose()
        }
    }


}