package com.example.demo2.mybatisPlus.service.impl;

import com.example.demo2.mybatisPlus.entity.Student;
import com.example.demo2.mybatisPlus.mapper.StudentMapper;
import com.example.demo2.mybatisPlus.service.IStudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
