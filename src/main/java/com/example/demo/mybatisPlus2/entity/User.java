package com.example.demo.mybatisPlus2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wang
 * @since 2020-10-27
 */
@TableName("user")
public class User implements Serializable {


    /**
     * id号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 值
     */
    @TableField("value")
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