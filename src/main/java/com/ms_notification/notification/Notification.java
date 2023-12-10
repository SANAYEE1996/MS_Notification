package com.ms_notification.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Document("notification")
public class Notification {

    @Id
    @Field(value = "_id", targetType = FieldType.OBJECT_ID)
    private String id;

    @Indexed
    private Long schedule;

    @Indexed
    private Long member;

    private String email;

    private String title;

    private String time;

    public Notification(Long schedule, Long member, String member_email, String title, String time) {
        this.schedule = schedule;
        this.member = member;
        this.email = member_email;
        this.title = title;
        this.time = time;
    }
}
