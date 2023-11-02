package com.ms_notification.service;

import com.ms_notification.document.Notification;
import com.ms_notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void save(Notification notification){
        notificationRepository.save(notification);
    }
}
