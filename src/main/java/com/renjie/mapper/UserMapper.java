package com.renjie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.renjie.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: fan
 * @Date: 2020/11/12
 * @Description:
 */
//在对应的Mapper上面集成基本的类 BaseMapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
