package com.billy.mp4doubleds.service

import com.billy.mp4doubleds.mapper.ds1.UserMapper
import com.billy.mp4doubleds.model.ds1.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


interface UserService {
    fun create(user: User)
}

@Service
class UserServiceImpl(
    @Autowired val userMapper: UserMapper
) : UserService {
    override fun create(user: User) {
        println(user)
        userMapper.insert(user)
    }
}