package com.example.infreanjavatest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Study {

    @Builder.Default
    private StudyStatus status = StudyStatus.DRAFT;

    @Builder.Default
    private Integer limit = 5;

}