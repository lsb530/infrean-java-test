package com.example.infreanjavatest.domain;

import java.time.LocalDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Study {

    @Id
    @GeneratedValue
    private Long id;

    @Builder.Default
    private StudyStatus status = StudyStatus.DRAFT;

    private String name;
    private LocalDateTime openedDateTime;
    private Long ownerId;

    @Builder.Default
    private Integer limitCount = 5;

    public Study(Integer limit, String name) {
        this.limitCount = limit;
        this.name = name;
    }

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit은 0보다 커야한다.");
        }
        this.limitCount = limit;
    }

    public void open() {
        this.openedDateTime = LocalDateTime.now();
        this.status = StudyStatus.OPENED;
    }

}