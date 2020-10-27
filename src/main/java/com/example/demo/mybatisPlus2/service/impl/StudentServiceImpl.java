package com.example.demo.mybatisPlus2.service.impl;

import com.example.demo.mybatisPlus2.entity.Student;
import com.example.demo.mybatisPlus2.mapper.StudentMapper;
import com.example.demo.mybatisPlus2.service.IStudentService;
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
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
