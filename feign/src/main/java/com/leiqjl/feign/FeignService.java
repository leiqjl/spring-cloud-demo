package com.leiqjl.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "hello-service", fallback = FeignFallBack.class)
public interface FeignService {

    @GetMapping("hello")
    String hello();

    @GetMapping("test")
    String test(@RequestParam String name);

    @GetMapping("test1")
    User test1(@RequestParam String name, @RequestHeader Integer age);

    @PostMapping("test2")
    String test2(@RequestBody User user);

}
