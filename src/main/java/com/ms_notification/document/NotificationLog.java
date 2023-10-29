package com.ms_notification.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Document("log")
public class NotificationLog {

    @MongoId
    private String id;

    private String notification_id;

    private String send_time;
}
