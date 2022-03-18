package com.songi.findyourseat.domain.studyRoom.domain;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Table(name = "STUDY_ROOM")
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int countOfSeats = 0;

    @Embedded
    private Seats seats = new Seats(0);

    protected StudyRoom(String name, int countOfSeats) {
        this(null, name, countOfSeats, new Seats(countOfSeats));
    }

    public static StudyRoom of(String name, int countOfSeats) {
        return new StudyRoom(name, countOfSeats);
    }
}
