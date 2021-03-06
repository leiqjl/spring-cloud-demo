package com.leiqjl.streamprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

    @Autowired
    private SendService sendService;
    @Autowired
    private TestSendService testSendService;

    @RequestMapping("/send/{msg}")
    public void send(@PathVariable("msg") String msg){
        sendService.sendMsg(msg);
    }

    @RequestMapping("/test/send/{msg}")
    public void testSend(@PathVariable("msg") String msg){
        testSendService.sendMsg(msg);
    }

}
