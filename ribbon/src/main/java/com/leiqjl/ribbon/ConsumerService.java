package com.leiqjl.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "testFallback")
    public String consumer() {
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }

    public String testFallback() {
        return "fail";
    }


    public String command() throws Exception {
        ConsumerCommand command = new ConsumerCommand("command", restTemplate);
        String result = command.execute();
        return result;
    }
}
