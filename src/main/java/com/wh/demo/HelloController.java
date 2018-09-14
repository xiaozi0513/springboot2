package com.wh.demo;

import com.wh.mapper.axx.domain.User;
import com.wh.mapper.bxx.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Hello Spring Boot 2.0
 *
 * @author: wang_hui
 * @date: 2018/9/12 下午4:36
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/demo/hello")
    public String hello() {
        List<User> userList = helloService.selectAll();
        System.out.println("=====" + userList.size());
        Book book = helloService.selectById(1L);
        System.out.println(">>>>>" + book.toString());
        return "Hello, Spring Boot 2.0.4";
    }

}
