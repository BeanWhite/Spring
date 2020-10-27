package com.example.demo.mybatisPlus.controller;


import com.example.demo.mybatisPlus.service.IStudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-10-27
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private IStudentService iStudentService;

    @GetMapping("/t")
    public void test(){
        iStudentService.test();
    }

}
