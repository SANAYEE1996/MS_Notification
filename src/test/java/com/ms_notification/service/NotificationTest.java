package com.ms_notification.service;

import com.ms_notification.document.Notification;
import com.ms_notification.dto.NotificationDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class NotificationTest {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private Convert convert;

    @DisplayName("save all test")
    @Test
    void saveAllTest(){
        List<NotificationDto> notificationDtoList = new ArrayList<>();
        notificationDtoList.add(new NotificationDto(1L, 1L, "dudtkd0219@gmail.com", "식당예약", "2023-11-10 17:00"));
        notificationDtoList.add(new NotificationDto(1L, 1L, "dudtkd0219@gmail.com", "식당예약", "2023-11-10 18:00"));
        notificationDtoList.add(new NotificationDto(1L, 1L, "dudtkd0219@gmail.com", "식당예약", "2023-11-10 18:40"));
        List<Notification> notificationList = convert.toNotificationList(notificationDtoList);
        notificationService.saveAll(notificationList);
    }

}
