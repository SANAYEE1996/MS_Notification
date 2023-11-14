package com.ms_notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
@SpringBootApplication
public class MsNotificationApplication {

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(MsNotificationApplication.class, args);

        String[] singers = {"임재범", "박정현", "이재훈", "박효신", "김범수"};

        log.info("### Concert start");

        Flux<String> concertFlux = Flux.fromArray(singers).delayElements(Duration.ofSeconds(1)).share();

        concertFlux.subscribe(singer -> log.info("# 박영상 is watching {}'s song", singer));

        Thread.sleep(2500);

        concertFlux.subscribe(singer -> log.info("# 홍길동 is watching {}'s song", singer));

        Thread.sleep(3000);
    }

}
