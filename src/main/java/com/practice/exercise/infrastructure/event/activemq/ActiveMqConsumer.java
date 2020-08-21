package com.practice.exercise.infrastructure.event.activemq;

import com.practice.exercise.application.handler.counter.IncrementCounterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import static com.practice.exercise.infrastructure.event.activemq.ActiveMqConstants.*;

@Component
public class ActiveMqConsumer {

    private IncrementCounterHandler incrementCounterHandler;

    @Autowired
    public ActiveMqConsumer(IncrementCounterHandler incrementCounterHandler) {
        this.incrementCounterHandler = incrementCounterHandler;
    }

    @JmsListener(destination = DEVICE_COUNTER_QUEUE)
    public void consumeDeviceCounter(String message) {
        this.incrementCounterHandler.count(message);
    }
}
