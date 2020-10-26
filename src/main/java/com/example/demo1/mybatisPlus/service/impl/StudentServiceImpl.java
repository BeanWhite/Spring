package com.example.demo1.mybatisPlus.service.impl;

import com.example.demo1.mybatisPlus.entity.Student;
import com.example.demo1.mybatisPlus.mapper.StudentMapper;
import com.example.demo1.mybatisPlus.service.IStudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
