package com.wh.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello Spring Boot 2.0
 *
 * @author: wang_hui
 * @date: 2018/9/12 下午4:36
 */
@RestController
public class HelloController {

    @RequestMapping("/demo/hello")
    public String hello() {
        int a = 1/0;
        return "Hello, Spring Boot 2.0.4";
    }

}
