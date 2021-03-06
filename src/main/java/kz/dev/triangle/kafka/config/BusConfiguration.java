package kz.dev.triangle.kafka.config;

import kz.dev.triangle.kafka.stream.ITriangleEventStream;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;


@ConditionalOnProperty(prefix = "spring.cloud.stream.kafka.binder", name= "brokers")
@Configuration
@EnableBinding(value= {ITriangleEventStream.class})
public class BusConfiguration {
}
