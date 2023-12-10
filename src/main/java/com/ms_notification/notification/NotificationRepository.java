package com.ms_notification.notification;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface NotificationRepository extends ReactiveMongoRepository<Notification, String> {

    Mono<Integer> deleteBySchedule(Long id);
}
