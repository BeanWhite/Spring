package com.example.demo.mybatisPlus2.service.impl;

import com.example.demo.mybatisPlus2.entity.User;
import com.example.demo.mybatisPlus2.mapper.UserMapper;
import com.example.demo.mybatisPlus2.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wang
 * @since 2020-10-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
