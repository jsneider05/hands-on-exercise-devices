package com.practice.exercise.infrastructure.configuration.activemq;

import com.practice.exercise.infrastructure.configuration.jwt.JwtConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@Profile("!test")
@Configuration
@EnableJms
@EnableConfigurationProperties(ActiveMqPropertiesConfig.class)
public class ActiveMqListenerConfig {

    private final ActiveMqPropertiesConfig activeMqProperties;
    private final ConnectionFactory connectionFactory;

    @Autowired
    public ActiveMqListenerConfig(ActiveMqPropertiesConfig activeMqProperties,
                                  ConnectionFactory connectionFactory) {
        this.activeMqProperties = activeMqProperties;
        this.connectionFactory = connectionFactory;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrency(activeMqProperties.getConcurrency());
        return factory;
    }
}
