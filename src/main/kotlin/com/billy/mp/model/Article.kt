package com.billy.mp.model

import com.baomidou.mybatisplus.annotation.TableId
import com.gitee.sunchenbin.mybatis.actable.annotation.Column
import com.gitee.sunchenbin.mybatis.actable.annotation.IsKey
import com.gitee.sunchenbin.mybatis.actable.annotation.Table
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel

@Table(name = "article")
class Article(
    @TableId @IsKey @Column val articleId: Long,
    @Column(name = "title", comment = "标题")
    val title: String,
    @Column(name = "content", comment = "内容")
    val content: String
) : BaseModel()