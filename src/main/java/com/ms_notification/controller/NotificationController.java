package com.ms_notification.controller;

import com.ms_notification.dto.NotificationDto;
import com.ms_notification.service.Convert;
import com.ms_notification.service.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    private final Convert convert;

    @PostMapping(value = "/save")
    public void save(@RequestBody @Valid List<NotificationDto> notificationDtoList){
        try {
            notificationService.saveAll(convert.toNotificationList(notificationDtoList));
        }catch (RuntimeException e){
            log.error(e.getMessage());
        }
    }
}
