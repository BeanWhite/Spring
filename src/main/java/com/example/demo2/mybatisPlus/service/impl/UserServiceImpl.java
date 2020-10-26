package com.example.demo2.mybatisPlus.service.impl;

import com.example.demo2.mybatisPlus.entity.User;
import com.example.demo2.mybatisPlus.mapper.UserMapper;
import com.example.demo2.mybatisPlus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-10-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
