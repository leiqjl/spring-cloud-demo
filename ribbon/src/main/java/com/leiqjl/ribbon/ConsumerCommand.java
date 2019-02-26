package com.leiqjl.ribbon;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

public class ConsumerCommand extends HystrixCommand<String> {

    private RestTemplate restTemplate;

    protected ConsumerCommand(String commandKey, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey(commandKey));
        this.restTemplate = restTemplate;
    }

    @Override
    protected String run() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
    }

    @Override
    protected String getFallback() {
        return "fail";
    }
}
