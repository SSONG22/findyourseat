package com.songi.findyourseat.domain.studyRoom.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("seats test")
class SeatsTest {

    @DisplayName("자리 추가하면 전체 자리 수가 증가한다.")
    @Test
    void add() {
        Seats seats = new Seats(10);
        seats.add(new Seat(11));
        assertThat(seats.count()).isEqualTo(11);
    }

    @DisplayName("자리를 없애면 전체 자리 수가 감소한다.")
    @Test
    void remove() {
        Seats seats = new Seats(10);
        seats.remove(new Seat(10));
        assertThat(seats.count()).isEqualTo(9);
    }

    @DisplayName("사용자가 체크인을 하면 가능한 좌석 수가 감소한다.")
    @Test
    void checkIn() {
        Seats seats = new Seats(10);
        seats.checkIn(1, "1");
        assertThat(seats.availableSeats()).isEqualTo(9);
    }

    @DisplayName("사용자가 체크아웃하면 가능한 좌석 수가 증가한다.")
    @Test
    void checkOut() {
        // given
        Seats seats = new Seats(10);
        seats.checkIn(1, "1");
        int firstCountOfSeats = seats.availableSeats();

        // then
        seats.checkOut(1, "1");
        assertThat(seats.availableSeats()).isEqualTo(firstCountOfSeats + 1);
    }

    @DisplayName("사용자가 체크아웃할때 체크인한 유저아이디와 다르면 예외가 발생한다.")
    @Test
    void checkOut_fail() {
        // given
        Seats seats = new Seats(10);
        seats.checkIn(1, "1");
        // then
        assertThrows(RuntimeException.class,
                () -> seats.checkOut(1, "2"),
                "different userInfo");
    }
}