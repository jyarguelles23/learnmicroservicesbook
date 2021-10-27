package com.viqsystems.gamification.DTOs;

import lombok.Value;

@Value
public class ChallengeSolvedEvent {
    long attemptId;
    boolean correct;
    int factorA;
    int factorB;
    long userId;
    String userAlias;
}
/*
Following domain-driven design practices, we could adjust this event’s deserialized
fields. For instance, we don’t need the userAlias for the Gamification’s business
logic, so we could remove it from the consumed event. Since Spring Boot configures
the ObjectMapper to ignore unknown properties by default, that strategy would work
without needing to configure anything else.
Not sharing the code of this class across
microservices is a good practice because it also allows for loose coupling, backward
compatibility, and independent deployments.*/