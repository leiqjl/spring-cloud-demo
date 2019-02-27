package com.leiqjl.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private FeignService feignService;

    @GetMapping("consumer")
    public String consumer() {
        String result1 = feignService.test("jack");
        User user = feignService.test1("jack1", 18);
        String result2 = user.getName() + ":" + user.getAge();
        String result3 = feignService.test2(new User("jack2", 19));
        return result1 + "\n" + result2 + "\n" + result3;
    }
}
