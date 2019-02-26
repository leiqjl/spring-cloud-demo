package com.leiqjl.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/consumer")
    public String consumer() {
        return consumerService.consumer();
    }

    @RequestMapping("/async")
    public String async() throws ExecutionException, InterruptedException {
        return consumerService.async();
    }

    @RequestMapping("/command")
    public String command() {
        return consumerService.command();
    }

    @RequestMapping("/commandAsync")
    public String commandAsync() throws ExecutionException, InterruptedException {
        return consumerService.commandAsync();
    }
}
