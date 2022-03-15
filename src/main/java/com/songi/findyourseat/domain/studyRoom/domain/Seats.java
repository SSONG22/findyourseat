package com.songi.findyourseat.domain.studyRoom.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seats {

    @OneToMany(mappedBy = "studyRoom",
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)

    private Set<Seat> seats;

    protected Seats(int size) {
        this.seats = new HashSet<>();
        for (int number = 1; number <= size; number++) {
            seats.add(new Seat(number));
        }
    }

    protected Seats(Set<Seat> seats) {
        this.seats = seats;
    }

    public void add(Seat seat) {
        seats.add(seat);
    }

    public void checkIn(int number, String userInfo) {
        getSeat(number)
                .checkIn(userInfo);
    }

    public void checkOut(int number, String userInfo) {
        getSeat(number)
                .checkOut(userInfo);
    }

    private Seat getSeat(int number) {
        return seats.stream()
                .filter(seat -> seat.isSameSeat(number))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("can't find seat"));
    }

    public int count() {
        return seats.size();
    }
}
