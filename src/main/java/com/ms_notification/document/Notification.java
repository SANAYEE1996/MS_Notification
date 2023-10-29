package com.ms_notification.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Document("notification")
public class Notification {

    @MongoId
    private String id;

    private Long schedule_id;

    private Long member_id;

    private String member_email;

    private String time;
}
