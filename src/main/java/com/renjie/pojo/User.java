package com.renjie.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Author: fan
 * @Date:
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    //对应数据库中的主键id
    // 默认就是全局唯一id ID_WORKER
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //mybatisplus的乐观锁
    @Version
    private Integer version;

    @TableLogic//逻辑删除
    private Integer deleted;

}
