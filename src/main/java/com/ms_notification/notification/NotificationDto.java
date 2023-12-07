package com.ms_notification.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {

    private Long schedule_id;

    private Long member_id;

    private String member_email;

    private String title;

    private String time;
}