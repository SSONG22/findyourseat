package com.songi.findyourseat.domain.studyRoom.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyRoomTest {

    @DisplayName("스터디룸 생성시 스터디지점 이름과 좌석갯수를 받는다.")
    @Test
    void create() {
        StudyRoom studyRoom = new StudyRoom("구의점",12);
        assertThat(studyRoom.getSeats().count()).isEqualTo(12);
    }
}