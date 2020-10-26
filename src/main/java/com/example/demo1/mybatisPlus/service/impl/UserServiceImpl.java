package com.example.demo1.mybatisPlus.service.impl;

import com.example.demo1.mybatisPlus.entity.User;
import com.example.demo1.mybatisPlus.mapper.UserMapper;
import com.example.demo1.mybatisPlus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wang
 * @since 2020-10-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
