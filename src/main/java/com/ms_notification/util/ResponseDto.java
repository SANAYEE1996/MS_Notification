package com.ms_notification.util;

import lombok.Builder;

@Builder
public record ResponseDto(Integer code, String message, ResponseBody<?> body) {
}
