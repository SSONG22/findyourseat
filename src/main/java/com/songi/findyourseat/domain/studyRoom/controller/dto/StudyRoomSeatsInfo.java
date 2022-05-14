package com.songi.findyourseat.domain.studyRoom.controller.dto;

import com.songi.findyourseat.domain.studyRoom.dto.SeatInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class StudyRoomSeatsInfo {

    private Long studyRoomId;
    private String studyRoomName;
    private List<SeatInfo> seatInfos;

    public static StudyRoomSeatsInfo of(Long studyRoomId, String studyRoomName, List<SeatInfo> seatInfos) {
        return StudyRoomSeatsInfo.builder()
                .studyRoomId(studyRoomId)
                .studyRoomName(studyRoomName)
                .seatInfos(seatInfos)
                .build();
    }
}
