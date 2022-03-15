package com.songi.findyourseat.domain.studyRoom.service;

import com.songi.findyourseat.domain.studyRoom.repository.StudyRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyRoomService {

    private final StudyRoomRepository studyRoomRepository;

    public void checkIn(Long studyRoomId, Long seatId, String userId) {

    }
}
