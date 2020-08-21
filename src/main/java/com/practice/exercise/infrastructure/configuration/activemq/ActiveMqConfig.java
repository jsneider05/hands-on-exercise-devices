package com.practice.exercise.infrastructure.configuration.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import static com.practice.exercise.infrastructure.event.activemq.ActiveMqConstants.DEVICE_COUNTER_QUEUE;

@Configuration
@EnableConfigurationProperties(ActiveMqPropertiesConfig.class)
public class ActiveMqConfig {

    private final ActiveMqPropertiesConfig activeMqProperties;

    @Autowired
    public ActiveMqConfig(ActiveMqPropertiesConfig activeMqProperties) {
        this.activeMqProperties = activeMqProperties;
    }

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(DEVICE_COUNTER_QUEUE);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(activeMqProperties.getBrokerUrl());
        connectionFactory.setUserName(activeMqProperties.getUserName());
        connectionFactory.setPassword(activeMqProperties.getPassword());
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        return new JmsTemplate(connectionFactory());
    }
}
