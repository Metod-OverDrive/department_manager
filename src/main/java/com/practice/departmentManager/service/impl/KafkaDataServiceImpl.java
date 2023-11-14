package com.practice.departmentManager.service.impl;

import com.practice.departmentManager.domain.mailRemind.Remind;
import com.practice.departmentManager.service.KafkaDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Service
@RequiredArgsConstructor
public class KafkaDataServiceImpl implements KafkaDataService {

    private final KafkaSender<String, Object> sender;
    private final String topic = "task-remind";

    @Override
    public void send(Remind remind) {
        sender.send(
                Mono.just(SenderRecord.create(
                        topic,
                        0,
                        System.currentTimeMillis(),
                        String.valueOf(remind.hashCode()),
                        remind,
                        null
                ))
        ).subscribe();
    }
}
