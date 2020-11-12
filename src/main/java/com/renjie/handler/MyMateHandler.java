package com.renjie.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: fan
 * @Date: 2020/11/12
 * @Description:
 */
@Slf4j
@Component//记得把处理器加入IOC容器当中
public class MyMateHandler implements MetaObjectHandler {

    //插入时候的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入填充策略");
        //这里的三个参数 String fieldName, Object fieldVal, MetaObject metaObject
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    //更新时候的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新填充策略");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
