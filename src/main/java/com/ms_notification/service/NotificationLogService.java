package com.ms_notification.service;

import com.ms_notification.document.NotificationLog;
import com.ms_notification.repository.NotificationLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationLogService {

    private final NotificationLogRepository notificationLogRepository;

    public void save(NotificationLog notificationLog){
        notificationLogRepository.save(notificationLog);
    }
}
