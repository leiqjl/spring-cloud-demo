package com.leiqjl.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignFallBack implements FeignService {
    @Override
    public String hello() {
        return "fail";
    }

    @Override
    public String test(String name) {
        return "test fail";
    }

    @Override
    public User test1(String name, Integer age) {
        return new User();
    }

    @Override
    public String test2(User user) {
        return "test2 fail";
    }
}
