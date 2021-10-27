package com.viqsystems.logs.Configuration;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AMQPConfiguration {
    /*
    * We need a Spring Boot configuration class to declare the exchange, the queue where
we want to consume the messages from, and the binding object to attach the queue
to the topic exchange with a binding key pattern to consume all of them
    * */
    @Bean
    public TopicExchange logsExchange() {
        return ExchangeBuilder.topicExchange("logs.topic")
                .durable(true)
                .build();
    }
    @Bean
    public Queue logsQueue() {
        return QueueBuilder.durable("logs.queue").build();
    }

    @Bean
    public Binding logsBinding(final Queue logsQueue,
                               final TopicExchange logsExchange) {
        return BindingBuilder.bind(logsQueue)
                .to(logsExchange).with("#");
    }
}
