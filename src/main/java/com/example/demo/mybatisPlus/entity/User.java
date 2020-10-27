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
public class User implements Serializable {


    /**
     * id号
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 值
     */
    private String value;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }
    public String getValue() {
        return value;
    }

    public User setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", value=" + value +
        "}";
    }
}