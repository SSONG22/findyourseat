package com.songi.findyourseat.domain.studyRoom.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seats {

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            orphanRemoval = true)
    private Set<Seat> seats;

    protected Seats(int size) {
        this.seats = new HashSet<>();
        IntStream.rangeClosed(1, size)
                .forEach(number -> seats.add(new Seat(number)));
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

    public Seat getSeat(int number) {
        return seats.stream()
                .filter(seat -> seat.isSameSeat(number))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("can't find seat"));
    }

    public int count() {
        return seats.size();
    }

    public void remove(Seat seat) {
        seats.remove(seat);
    }

    public int availableSeats() {
        return (int) seats.stream()
                .filter(seat -> seat.isEmpty())
                .count();
    }

}
