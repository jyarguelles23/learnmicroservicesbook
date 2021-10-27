package com.viqsystems.gamification.Configuration;

import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;
@Configuration
public class AMQPConfiguration {

    // Ver como puedo hacer 2 de estos para distintos metodos
    @Bean
    public TopicExchange challengesTopicExchange(
            @Value("${amqp.exchange.attempts}") final String exchangeName) {
        return ExchangeBuilder.topicExchange(exchangeName).durable(true).build();
    }
    @Bean
    public Queue gamificationQueue(
            @Value("${amqp.queue.gamification}") final String queueName) {
        return QueueBuilder.durable(queueName).build();
    /*
    @Bean
public Queue gamificationQueue(
@Value("${amqp.queue.gamification}") final String queueName) {
return QueueBuilder.durable(queueName)
.ttl((int) Duration.ofHours(6).toMillis())
.maxLength(25000)
.build();
}
    * */
    }


    @Bean
    public Binding correctAttemptsBinding(final Queue gamificationQueue,
                                          final TopicExchange attemptsExchange) {
        return BindingBuilder.bind(gamificationQueue)
                .to(attemptsExchange)
                .with("attempt.correct");
    }
    @Bean
    public MessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new
                DefaultMessageHandlerMethodFactory();
        final MappingJackson2MessageConverter jsonConverter =
                new MappingJackson2MessageConverter();
        jsonConverter.getObjectMapper().registerModule(
                new ParameterNamesModule(JsonCreator.Mode.PROPERTIES));
        factory.setMessageConverter(jsonConverter);
        return factory;
    }

    @Bean
    public RabbitListenerConfigurer rabbitListenerConfigurer(
            final MessageHandlerMethodFactory messageHandlerMethodFactory) {
        return (c) -> c.setMessageHandlerMethodFactory(messageHandlerMethodFactory);
    }

    /*
    * The declaration of the exchange, queue, and binding are straightforward with the
provided builders. We declare a durable queue to make it survive broker restarts, with
a name coming from the configuration value. The Bean’s declaration method for the
Binding uses the two other beans, injected by Spring, and links them with the value
attempt.correct. As mentioned already, we’re interested only in the correct attempts to
process scores and badges.
Next to that, we set up a MessageHandlerMethodFactory bean to replace the default
one. We actually use the default factory as a baseline but then replace its message
converter by a MappingJackson2MessageConverter instance, which handles the message
deserialization from JSON to Java classes. We fine-tune its included ObjectMapper and
add the ParameterNamesModule to avoid having to use empty constructors for our event
classes. Note that we didn’t need to do this when passing DTOs via REST APIs (our
previous implementation) because Spring Boot configures this module within the web
layer autoconfiguration. However, it doesn’t do this for RabbitMQ because JSON is not
the default option; therefore, we need to configure it explicitly.
This time, we won’t use the AmqpTemplate to receive messages since that’s based
on polling, which consumes network resources unnecessarily. Instead, we want the
broker to notify subscribers when there are messages, so we’ll go for an asynchronous
option. The AMQP abstraction doesn’t support this, but the spring-rabbit component
offers two mechanisms for consuming messages asynchronously. The simplest, most
popular one is the @RabbitListener annotation, which we’ll use to get the events from
the queue. To configure the listeners to use a JSON deserialization, we have to override
the bean RabbitListenerConfigurer with an implementation that uses our custom
MessageHandlerMethodFactory
    * */
}
