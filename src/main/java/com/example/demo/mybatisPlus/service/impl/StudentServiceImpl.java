package com.example.demo.mybatisPlus.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.mybatisPlus.entity.Student;
import com.example.demo.mybatisPlus.mapper.StudentMapper;
import com.example.demo.mybatisPlus.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-10-27
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Resource
    private IService<Student> iService;

    @Resource
    private StudentMapper studentMapper;

    @Override
    public void test() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            Student student = new Student();
            student.setSex("fa");
            student.setName("ghgh");
            student.setId(i + 10);
            students.add(student);
        }

      boolean b =  iService.saveBatch(students);
        System.out.println(b);
    }
}
