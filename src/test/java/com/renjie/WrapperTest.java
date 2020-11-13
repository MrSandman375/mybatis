package com.renjie;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.renjie.mapper.UserMapper;
import com.renjie.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

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
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age",12);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void test2(){
        //查询单个值
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","Sandy");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    void test3(){
        //查询区间值
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,25);
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }

    @Test
    void test4(){
        //模糊查询
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper
                .notLike("name","o")
                //左和右 t%
                .likeRight("email","t");
        List<Map<String,Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    void test5(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //id 在子查询中查出来
        wrapper.inSql("id","select id from user where id<3");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test6(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //通过id进行排序
        wrapper.orderByDesc("id");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }


}
