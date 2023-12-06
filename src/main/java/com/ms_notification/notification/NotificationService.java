package com.ms_notification.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public Mono<String> saveAll(List<Notification> notificationList){
        return notificationRepository.saveAll(notificationList).collectList()
                .flatMap(req -> Mono.just("save success"));
    }
}
