package com.ms_notification.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {

    @NotNull(message = "유효하지 않은 type 값")
    private Long schedule_id;

    @NotNull(message = "유효하지 않은 type 값")
    private Long member_id;

    @NotBlank(message = "유효하지 않은 type 값")
    private String member_email;

    @NotBlank(message = "유효하지 않은 type 값")
    private String title;

    @NotBlank(message = "유효하지 않은 type 값")
    private String time;
}