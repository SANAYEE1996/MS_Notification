package com.ms_notification.service;

import com.ms_notification.document.Notification;
import com.ms_notification.dto.NotificationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class Convert {

    public List<Notification> toNotificationList(List<NotificationDto> notificationDtoList){
        return notificationDtoList.stream().map(this::toNotification).collect(Collectors.toList());
    }

    private Notification toNotification(NotificationDto notificationDto){
        return new Notification(notificationDto.getSchedule_id(), notificationDto.getMember_id(), notificationDto.getMember_email(), notificationDto.getTitle(), notificationDto.getTime());
    }
}
