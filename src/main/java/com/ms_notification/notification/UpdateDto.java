package com.ms_notification.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDto {

    private Long scheduleId;

    private List<NotificationDto> dtoList;
}