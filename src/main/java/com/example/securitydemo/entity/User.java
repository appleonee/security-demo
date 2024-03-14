package com.example.securitydemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * ClassName: User
 * Package: com.example.securitydemo.entity
 * Description:
 *
 * @Author cyh
 * @Create 2024/3/14 10:20
 * @Version 1.0
 */
@Data
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private Boolean enabled;//是否启用

}
