package com.ms_notification.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Slf4j
@Configuration("notificationRouter")
public class NotificationRouter {

    @Bean
    public RouterFunction<?> routeNotification(NotificationHandler handler){
        return route()
                .POST("/notification/save", accept(MediaType.APPLICATION_JSON), handler::save)
                .POST("/notification/update", accept(MediaType.APPLICATION_JSON), handler::update)
                .GET("/notification/delete/{id}", handler::delete)
                .build();
    }
}
