package com.songi.findyourseat.domain.studyRoom.repository;

import com.songi.findyourseat.domain.studyRoom.domain.StudyRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class StudyRoomRepositoryTest {

    @Autowired
    private StudyRoomRepository repository;

    @Autowired
    private TestEntityManager em;

    private StudyRoom 구의점;

    @BeforeEach
    void setup() {
        구의점 = repository.save(StudyRoom.of("구의점", 20));
    }

    @Test
    void 스터디룸_생성_findByName() {
        Optional<StudyRoom> studyRoom = repository.findByName("구의점");
        assertThat(studyRoom.isPresent()).isTrue();
        assertThat(studyRoom.get()).isEqualTo(구의점);
    }

    @Test
    void 스터디룸_좌석_선점() {
        구의점.checkIn(1, "user1");
        em.flush();
        em.clear();
        Optional<StudyRoom> studyRoom = repository.findByName("구의점");
        assertThat(studyRoom.get().getSeats().availableSeats()).isEqualTo(19);
        assertThat(studyRoom.get().getSeat(1).getNumber()).isEqualTo(1);
    }

    @Test
    void 스터디룸_좌석_체크아웃() {
        구의점.checkIn(1, "user1");
        em.flush();
        em.clear();
        Optional<StudyRoom> studyRoom = repository.findByName("구의점");
        studyRoom.get().checkOut(1, "user1");
        em.flush();
        em.clear();
        Optional<StudyRoom> studyRoom1 = repository.findByName("구의점");
        assertThat(studyRoom1.get().getSeats().availableSeats()).isEqualTo(20);
        assertThat(studyRoom1.get().getSeat(1).isEmpty()).isTrue();
    }

}