package com.leiqjl.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {

    @Value("${info.key}")
    private String key;
    @Value("${info.value}")
    private String value;

    @GetMapping("config")
    public String config() {
        return "key:" + key + ",value:" + value;
    }
}
