package kz.dev.triangle.kafka.stream;

import kz.dev.triangle.kafka.config.BusConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ITriangleEventStream {

    String OUTPUT = "triangleEvent";

    @Output(OUTPUT)
    @ConditionalOnBean(BusConfiguration.class)
    MessageChannel activeChangeProcess();
}
