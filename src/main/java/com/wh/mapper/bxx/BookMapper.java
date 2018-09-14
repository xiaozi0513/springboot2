package com.wh.mapper.bxx;

import com.wh.core.datasource.annotation.TargetDataSource;
import com.wh.mapper.bxx.domain.Book;
import org.springframework.stereotype.Repository;

/**
 * @author: wang_hui
 * @date: 2018/9/13 下午3:25
 */
@Repository
public interface BookMapper {
    @TargetDataSource("b")
    Book selectById(Long id);
}
