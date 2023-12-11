package com.ms_notification.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component("notificationHandler")
@RequiredArgsConstructor
public class NotificationHandler {

    private final RequestValidator<SaveDto> saveDtoValidator;

    private final RequestValidator<UpdateDto> updateDtoValidator;

    private final Convert convert;

    private final NotificationService notificationService;

    public Mono<ServerResponse> save(ServerRequest request){
        return request.bodyToMono(SaveDto.class)
                .doOnNext(saveDtoValidator::validate)
                .map(SaveDto::getDtoList)
                .doOnNext(req -> req.forEach(saveDtoValidator::notificationDtoValidate))
                .flatMap(req -> notificationService.saveAll(convert.toNotificationList(req)))
                .flatMap(req -> ServerResponse.ok().bodyValue(req))
                .onErrorResume(req -> ServerResponse.badRequest().bodyValue(req.getMessage()));
    }

    public Mono<ServerResponse> update(ServerRequest request){
        return request.bodyToMono(UpdateDto.class)
                .doOnNext(updateDtoValidator::validate)
                .doOnNext(req -> {
                    if(req.getScheduleId() == null) throw new RuntimeException("Schedule Id must not be null");
                })
                .flatMap(req -> Mono.zip(Mono.just(req.getDtoList()), Mono.just(req.getScheduleId())))
                .flatMap(req -> Mono.zip(Mono.just(req.getT1()), Mono.just(notificationService.deleteBySchedule(req.getT2()))))
                .flatMap(req -> notificationService.saveAll(convert.toNotificationList(req.getT1())))
                .flatMap(req -> ServerResponse.ok().bodyValue("notify server update success"))
                .onErrorResume(req -> ServerResponse.badRequest().bodyValue(req.getMessage()));
    }

    public Mono<ServerResponse> delete(ServerRequest request){
        Long id = Long.valueOf(request.pathVariable("id"));
        return Mono.just(notificationService.deleteBySchedule(id))
                .flatMap(req -> ServerResponse.ok().bodyValue("notify server delete success"))
                .onErrorResume(req -> ServerResponse.badRequest().bodyValue(req.getMessage()));
    }
}
