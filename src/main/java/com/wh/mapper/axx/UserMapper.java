package com.wh.mapper.axx;

import com.wh.mapper.axx.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: wang_hui
 * @date: 2018/9/13 下午3:25
 */
@Repository
public interface UserMapper {
    List<User> selectList();
}
