package com.wh.mapper.bxx.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: wang_hui
 * @date: 2018/9/13 下午3:20
 */
@Data
@TableName(value = "book")
public class Book implements Serializable {
    private static final long serialVersionUID = -557007468867844839L;

    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 书名
     */
    private String title;

    /**
     * 数量
     */
    private Integer count;
}
