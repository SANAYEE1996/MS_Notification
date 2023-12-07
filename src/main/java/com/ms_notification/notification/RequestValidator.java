package com.ms_notification.notification;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

@Slf4j
@Component("RequestValidator")
@RequiredArgsConstructor
public class RequestValidator<T> {

    private final Validator validator;

    public void validate(T body) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(body);
        if (!constraintViolations.isEmpty()) {
            onValidationErrors(constraintViolations);
        }
    }

    public void notificationDtoValidate(NotificationDto dto){
        if(dto.getSchedule_id() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "schedule_id must not be null");
        }
        if(dto.getMember_id() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "member_id must not be null");
        }
        if(!StringUtils.hasText(dto.getMember_email())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "member_email must not be blank");
        }
        if(!StringUtils.hasText(dto.getTitle())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "title must not be blank");
        }
        if(!StringUtils.hasText(dto.getTime())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "time must not be blank");
        }
    }

    private void onValidationErrors(Set<ConstraintViolation<T>> constraintViolations) {
        log.error(constraintViolations.toString());
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                constraintViolations.toString());
    }
}
