package com.billy.mp4doubleds.mapper.ds1

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.billy.mp4doubleds.model.ds1.User
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper : BaseMapper<User>