package com.leiqjl.streamprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(TestSource.class)
public class TestSendService {
    @Autowired
    private TestSource testSource;

    public void sendMsg(String msg){
        testSource.testOutput().send(MessageBuilder.withPayload(msg).build());
    }
}
