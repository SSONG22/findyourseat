package com.songi.findyourseat.domain.studyRoom.repository;

import com.songi.findyourseat.domain.studyRoom.domain.StudyRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudyRoomRepository extends JpaRepository<StudyRoom, Long> {

    Optional<StudyRoom> findByName(String name);
}
