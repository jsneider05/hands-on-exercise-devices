package com.practice.exercise.infrastructure.repository.counter;

import com.practice.exercise.domain.repository.counter.CounterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CounterRepositoryImpl implements CounterRepository {

    private final Logger logger = LoggerFactory.getLogger(CounterRepositoryImpl.class);

    @Override
    public void count(String id) {
        logger.info("Message received {} ", id);
    }
}
