package com.leiqjl.streamprovider;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TestSource {

    @Output("testOutput")
    MessageChannel testOutput();
}
