package com.leiqjl.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    @HystrixCommand(fallbackMethod = "testFallback")
    public String async() throws ExecutionException, InterruptedException {
        Future<String> future = new AsyncResult<String>() {
            @Override
            public String invoke() {
                return restTemplate.getForEntity("http://hello-service/hello", String.class).getBody();
            }

            @Override
            public String get() throws UnsupportedOperationException {
                return invoke();
            }
        };
        return future.get();
    }


    public String command() {
        ConsumerCommand command = new ConsumerCommand("command", restTemplate);
        return command.execute();
    }

    public String commandAsync() throws ExecutionException, InterruptedException {
        ConsumerCommand command = new ConsumerCommand("commandAsync", restTemplate);
        Future<String> future = command.queue();
        return future.get();
    }
}
