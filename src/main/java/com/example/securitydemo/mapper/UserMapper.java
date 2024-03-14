package com.example.securitydemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.securitydemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: UserMapper
 * Package: com.example.securitydemo.mapper
 * Description:
 *
 * @Author cyh
 * @Create 2024/3/14 10:23
 * @Version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
