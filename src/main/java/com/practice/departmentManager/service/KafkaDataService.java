package com.practice.departmentManager.service;

import com.practice.departmentManager.domain.mailRemind.Remind;

public interface KafkaDataService {

    void send(Remind remind);

}
