package com.billy.mp.model

import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.io.Serializable

@TableName("article")
class Article(
    @TableId val articleId: Long,
    val title: String,
    val content: String
) : Serializable