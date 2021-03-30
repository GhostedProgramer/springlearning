package com.billy.mp4doubleds.model.ds1

import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable

@TableName("cuser")
class User : Serializable {

    @TableId
    val id: Long? = null

    var username: String? = null

    var password: String? = null

    override fun toString(): String {
        return "User(id=$id, username=$username, password=$password)"
    }


}