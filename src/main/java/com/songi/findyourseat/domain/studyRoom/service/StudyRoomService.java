package com.songi.findyourseat.domain.studyRoom.service;

import com.songi.findyourseat.domain.studyRoom.domain.StudyRoom;
import com.songi.findyourseat.domain.studyRoom.dto.SeatInfo;
import com.songi.findyourseat.domain.studyRoom.repository.StudyRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudyRoomService {

    private final StudyRoomRepository studyRoomRepository;

    @Transactional
    public void checkIn(Long studyRoomId, Integer seatId, String userId) {
        StudyRoom studyRoom = getStudyRoom(studyRoomId);
        studyRoom.checkIn(seatId, userId);
    }

    @Transactional
    public void checkOut(Long studyRoomId, Integer seatId, String userId) {
        StudyRoom studyRoom = getStudyRoom(studyRoomId);
        studyRoom.checkOut(seatId, userId);
    }

    public StudyRoom getStudyRoom(Long studyRoomId) {
        return studyRoomRepository.findById(studyRoomId).orElseThrow(() -> new RuntimeException("not found study room"));
    }

    public List<SeatInfo> seatsInfo(Long studyRoomId) {
        StudyRoom studyRoom = getStudyRoom(studyRoomId);
        return studyRoom.seats()
                .stream()
                .map(SeatInfo::from)
                .collect(Collectors.toList());
    }

}
