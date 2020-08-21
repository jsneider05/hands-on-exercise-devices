package com.practice.exercise.application.handler.counter;

import com.practice.exercise.domain.service.counter.IncrementCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IncrementCounterHandler {

    private IncrementCounterService incrementCounterService;

    @Autowired
    public IncrementCounterHandler(IncrementCounterService incrementCounterService) {
        this.incrementCounterService = incrementCounterService;
    }

    public void count(String id) {
        this.incrementCounterService.count(id);
    }
}
