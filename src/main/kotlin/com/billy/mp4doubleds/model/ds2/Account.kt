package com.billy.mp4doubleds.model.ds2

import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable

@TableName("account")
class Account : Serializable {
    @TableId
    val id: Long? = null

    var no: String? = null
    override fun toString(): String {
        return "Account(id=$id, no=$no)"
    }

}