package com.viqsystems.logs.Services;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LogsConsumer {

    @RabbitListener(queues = "logs.queue")
    public void log(final String msg,
                    @Header("level") String level,
                    @Header("amqp_appId") String appId) {
        Marker marker = MarkerFactory.getMarker(appId);

       if (level.equals("INFO")) {
           log.info(marker, msg);
       }
       else if (level.equals("Error")){
           log.error(marker, msg);
       }
       else if(level.equals(("WARN"))){
           log.warn(marker, msg);
       }
       /* switch (level) {
            case "INFO" -> log.info(marker, msg);
            case "ERROR" -> log.error(marker, msg);
            case "WARN" -> log.warn(marker, msg);
        }*/
    }
}
