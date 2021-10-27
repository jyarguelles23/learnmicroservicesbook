package com.viqsystems.gamification.Services.Impl;


import com.viqsystems.gamification.DTOs.ChallengeSolvedEvent;
import com.viqsystems.gamification.Services.Interfaces.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class GameEventHandler {

    private final GameService gameService;
    @RabbitListener(queues = "${amqp.queue.gamification}")
    void handleMultiplicationSolved(final ChallengeSolvedEvent event) {
        log.info("Challenge Solved Event received: {}", event.getAttemptId());
        try {
            gameService.newAttemptForUser(event);
        } catch (final Exception e) {
            log.error("Error when trying to process ChallengeSolvedEvent", e);
          // Avoids the event to be re-queued and reprocessed.
            //https://tpd.io/spring-amqp-exc others way to do it
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}

/*
* We can do a lot with the RabbitListener annotation. These are a few of the included
functionalities:
• Declare exchanges, queues, and bindings.
• Receive messages from multiple queues with the same method.
• Process the message headers by annotating extra arguments with
@Header (for a single value) or @Headers (for a map).
• Inject a Channel argument, so we can control acknowledgments,
for example.
• Implement a Request-Response pattern, by returning a value from
the listener.
• Move the annotation to the class level and use @RabbitHandler for
methods. This approach allows us to configure multiple methods to
process different message types that are coming through the same queue.
*
* For details about these use cases, check the Spring AMQP documentation (https://
tpd.io/samqp-docs).
* */