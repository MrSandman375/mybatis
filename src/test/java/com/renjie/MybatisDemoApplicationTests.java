package com.renjie;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.renjie.mapper.UserMapper;
import com.renjie.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class MybatisDemoApplicationTests {

    //继承了BaseMapper，所有的方法都来自自己的父类
    //也可以自己编写扩展方法
    @Autowired
    private UserMapper userMapper;

    @Test
    void context(){
        //参数是一个wrapper，条件构造器，这里先使用null
        //查询全部用户
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }


    //测试插入
    @Test
    public void testInsert(){
        User user = new User();
        user.setAge(21);
        user.setEmail("1733535060@qq.com");
        user.setName("帆");
        //这里没有设置id，但是mybatis-plus会自动生成id
        int result = userMapper.insert(user);
        System.out.println(result);//受影响的行数
        System.out.println(user);//这里能看到自动返回的id
    }

    //测试更新
    @Test
    public void testUpdate(){
        User user = new User();
        user.setName("帆船二号");
        user.setId(1326696782256881669L);
        //需要注意的是updateById 里面的参数是一个对象
        userMapper.updateById(user);
    }

    //测试乐观锁成功
    @Test
    public void testOptimisticLockerInnerInterceptor(){
        //查询用户信息
        User user = userMapper.selectById(1L);
        //修改用户信息
        user.setName("xian");
        user.setEmail("fanrnejie.1024@gmail.com");
        //执行更新操作
        userMapper.updateById(user);
    }

    //测试乐观锁失败
    @Test
    public void testOptimisticLockerInnerInterceptor2(){
        //线程1
        User user = userMapper.selectById(1L);
        user.setName("hou1");
        user.setEmail("fanrnejie.1024@gmail.com");

        //模拟另一个线程执行了操作
        User user1 = userMapper.selectById(1L);
        user1.setName("hou2");
        user1.setEmail("fanrnejie.1024@gmail.com");
        userMapper.updateById(user1);

        //执行更新操作
        userMapper.updateById(user); //如果没有乐观锁就会覆盖插队线程的值
    }

    //测试查询
    @Test
    public void testSelect(){
        //查询单个
//        User user = userMapper.selectById(1L);
//        System.out.println(user);

        //查询多个
//        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
//        users.forEach(System.out::println);

        //使用map条件查询
//        HashMap<String,Object> map = new HashMap<>();
//        map.put("name","hou2");
//        List<User> users = userMapper.selectByMap(map);
//        users.forEach(System.out::println);

        //分页查询
        //参数一：当前页       参数二：页面大小
//        Page<User> page = new Page<>(2, 5);
//        userMapper.selectPage(page,null);
//        page.getRecords().forEach(System.out::println);
//        System.out.println(page.getTotal());

    }

    //测试删除
    @Test
    public void testDeleteById(){
        //这里是根据id删除。批量删除，条件删除请参照上面的查询
//        userMapper.deleteById(1326696782256881669L);
        //逻辑删除
        userMapper.deleteById(4L);
    }

}
