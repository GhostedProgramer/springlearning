package com.billy.mp4doubleds.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.billy.mp4doubleds.model.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper : BaseMapper<User>