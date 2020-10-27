package com.example.demo.mybatisPlus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-10-27
 */
public class Student implements Serializable {


    /**
     * 姓名
     */
    private String name;

    /**
     * 学号
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 性别
     */
    private String sex;

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }
    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getSex() {
        return sex;
    }

    public Student setSex(String sex) {
        this.sex = sex;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
            "name=" + name +
            ", id=" + id +
            ", sex=" + sex +
        "}";
    }
}