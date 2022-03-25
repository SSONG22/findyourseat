package com.songi.findyourseat.domain.studyRoom.dto;

import com.songi.findyourseat.domain.studyRoom.domain.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SeatInfo {
    private int seatNumber;
    private String userId;
    private boolean isEmpty;

    public static SeatInfo from(Seat seat) {
        return new SeatInfo(seat.getNumber(), seat.getUserInfo(), seat.isEmpty());
    }
}
