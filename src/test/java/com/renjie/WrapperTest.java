package com.renjie;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.renjie.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: fan
 * @Date: 2020/11/12
 * @Description: 条件构造器
 */
@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads(){
        //查询name不为空，且邮箱不为空的，年龄大于12
        QueryWrapper
        userMapper.selectList()
    }
}
