package com.practice.exercise.infrastructure.event.activemq;

import com.practice.exercise.application.event.activemq.ActiveMqPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import static com.practice.exercise.infrastructure.event.activemq.ActiveMqConstants.*;

@Profile("!test")
@Component
public class ActiveMqPublisherImpl implements ActiveMqPublisher {

    private final JmsTemplate jmsTemplate;
    private final String queueName;

    @Autowired
    public ActiveMqPublisherImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
        this.queueName = DEVICE_COUNTER_QUEUE;
    }

    @Override
    public void publishDeviceCounter(String message) {
        jmsTemplate.convertAndSend(queueName, message);
    }
}
