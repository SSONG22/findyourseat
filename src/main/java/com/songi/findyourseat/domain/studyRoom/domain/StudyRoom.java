package com.songi.findyourseat.domain.studyRoom.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "STUDY_ROOM")
@EqualsAndHashCode(of = "id")
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

    public void checkIn(Integer seatId, String userId) {
        seats.checkIn(seatId, userId);
    }

    public void checkOut(Integer seatId, String userId) {
        seats.checkOut(seatId, userId);
    }

    public List<Seat> seats() {
        return new ArrayList<>(seats.getSeats());
    }

    public Seat getSeat(int number) {
        return seats.getSeat(number);
    }
}
