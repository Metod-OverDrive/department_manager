package com.practice.departmentManager.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.kafka.producer")
@Getter
@Setter
public class KafkaProperties {

    private String keySerializer;
    private String valueSerializer;

}
