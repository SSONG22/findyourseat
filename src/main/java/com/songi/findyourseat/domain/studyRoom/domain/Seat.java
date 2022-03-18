package com.songi.findyourseat.domain.studyRoom.domain;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@EqualsAndHashCode(of = {"id", "number"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    private String userInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_room_id")
    private StudyRoom studyRoom;

    private boolean isEmpty = Boolean.TRUE;

    protected Seat(int number) {
        this.number = number;
    }

    public boolean isSameSeat(int number) {
        return this.number.equals(number);
    }

    public void checkIn(String userInfo) {
        isEmpty = false;
        this.userInfo = userInfo;
    }

    public void checkOut(String userInfo) {
        if (!this.userInfo.equals(userInfo)) {
            throw new RuntimeException("different userInfo");
        }
        this.userInfo = userInfo;
        isEmpty = true;
    }
}
