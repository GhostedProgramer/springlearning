package com.billy.mp4doubleds.service

import com.baomidou.dynamic.datasource.annotation.DS
import com.billy.mp4doubleds.mapper.ds2.AccountMapper
import com.billy.mp4doubleds.model.ds2.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


interface AccountService {

    fun create(account: Account)
}

@DS("ds2")
@Service
class AccountServiceImpl(
    @Autowired val accountMapper: AccountMapper
) : AccountService {

    override fun create(account: Account) {
        println(account.id.toString() + " " + account.no)
        accountMapper.insert(account)
    }
}

