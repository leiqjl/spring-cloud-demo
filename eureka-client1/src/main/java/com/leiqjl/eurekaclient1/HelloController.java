package com.leiqjl.eurekaclient1;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("hello")
    public String hello() {
        return "hello1";
    }

    @GetMapping("test")
    public String test(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping("test1")
    public User test1(@RequestParam String name, @RequestHeader Integer age) {
        return new User(name, age);
    }

    @PostMapping("test2")
    public String test2(@RequestBody User user) {
        return "Hello "+user.getName()+"，" + user.getAge();
    }
}
