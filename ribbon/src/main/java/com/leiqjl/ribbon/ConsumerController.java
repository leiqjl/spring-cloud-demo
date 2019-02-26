package com.leiqjl.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/consumer")
    public String consumer() {
        return consumerService.consumer();
    }


    @RequestMapping("/command")
    public String command() throws Exception {
        return consumerService.command();
    }
}
