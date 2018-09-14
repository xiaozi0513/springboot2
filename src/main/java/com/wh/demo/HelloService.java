package com.wh.demo;

import com.wh.core.datasource.annotation.TargetDataSource;
import com.wh.mapper.axx.UserMapper;
import com.wh.mapper.axx.domain.User;
import com.wh.mapper.bxx.BookMapper;
import com.wh.mapper.bxx.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: wang_hui
 * @date: 2018/9/14 上午11:10
 */
@Service
public class HelloService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BookMapper bookMapper;

    public List<User> selectAll() {
        return userMapper.selectList();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @TargetDataSource("b")
    public Book selectById(Long id) {
        return bookMapper.selectById(id);
    }
}
