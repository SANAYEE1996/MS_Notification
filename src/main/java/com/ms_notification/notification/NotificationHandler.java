package com.ms_notification.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component("productHandler")
@RequiredArgsConstructor
public class NotificationHandler {

    private final RequestValidator validator;

    private final Convert convert;

    private final NotificationService notificationService;

    public Mono<ServerResponse> save(ServerRequest request){
        return request.bodyToMono(SaveDto.class)
                .doOnNext(validator::validate)
                .map(SaveDto::getDtoList)
                .doOnNext(req -> req.forEach(validator::notificationDtoValidate))
                .flatMap(req -> notificationService.saveAll(convert.toNotificationList(req)))
                .flatMap(req -> ServerResponse.ok().bodyValue(req))
                .onErrorResume(req -> ServerResponse.badRequest().bodyValue(req.getMessage()));
    }
}
