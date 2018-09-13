package com.wh.mapper.axx.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: wang_hui
 * @date: 2018/9/13 下午3:16
 */
@Data
@TableName(value = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 6895572490053516476L;

    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 姓名
     */
    private String name;
}
