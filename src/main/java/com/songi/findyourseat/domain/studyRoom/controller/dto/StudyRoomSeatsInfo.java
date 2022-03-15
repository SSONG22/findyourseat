package com.songi.findyourseat.domain.studyRoom.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class StudyRoomSeatsInfo {

    private Long studyRoomId;
    private String studyRoomName;

    public static StudyRoomSeatsInfo from() {
        return StudyRoomSeatsInfo.builder()
                .build();
    }
}
