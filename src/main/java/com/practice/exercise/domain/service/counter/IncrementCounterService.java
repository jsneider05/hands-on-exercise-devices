package com.practice.exercise.domain.service.counter;

import com.practice.exercise.domain.repository.counter.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncrementCounterService {

    private CounterRepository counterRepository;

    @Autowired
    public IncrementCounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public void count(String id) {
        this.counterRepository.count(id);
    }
}
