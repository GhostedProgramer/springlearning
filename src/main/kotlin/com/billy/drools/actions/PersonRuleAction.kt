package com.billy.drools.actions

import com.billy.drools.model.Person
import org.drools.core.definitions.rule.impl.RuleImpl
import org.slf4j.LoggerFactory

class PersonRuleAction {
    companion object {
        private val logger = LoggerFactory.getLogger(PersonRuleAction::class.java)
        fun doParse(person: Person?, rule: RuleImpl) {
            logger.debug("${person!!.name} is matched Rule[${rule.name}]!")
        }
    }
}