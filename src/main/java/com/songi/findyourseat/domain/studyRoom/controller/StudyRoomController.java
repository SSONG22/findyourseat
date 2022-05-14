package com.songi.findyourseat.domain.studyRoom.controller;

import com.songi.findyourseat.domain.studyRoom.controller.dto.StudyRoomSeatsInfo;
import com.songi.findyourseat.domain.studyRoom.domain.StudyRoom;
import com.songi.findyourseat.domain.studyRoom.service.StudyRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/studyRoom")
@RequiredArgsConstructor
public class StudyRoomController {

    private final StudyRoomService studyRoomService;

    @GetMapping("/{studyRoomId}/seats")
    public ResponseEntity<StudyRoomSeatsInfo> getSeatsInfo(@PathVariable Long studyRoomId) {
        StudyRoom studyRoom = studyRoomService.getStudyRoom(studyRoomId);
        return ResponseEntity.ok(StudyRoomSeatsInfo.of(studyRoomId, studyRoom.getName(), studyRoomService.seatsInfo(studyRoomId)));
    }

    @PostMapping("/{studyRoomId}/in/{seatId}")
    public ResponseEntity<String> checkIn(
            @PathVariable Long studyRoomId,
            @PathVariable Integer seatId,
            @RequestBody String userId
    ) {
        studyRoomService.checkIn(studyRoomId, seatId, userId);
        return ResponseEntity.ok("success");
    }

    @PostMapping("/{studyRoomId}/out/{seatId}")
    public ResponseEntity<String> checkOut(
            @PathVariable Long studyRoomId,
            @PathVariable Integer seatId,
            @RequestBody String userId
    ) {
        studyRoomService.checkOut(studyRoomId, seatId, userId);
        return ResponseEntity.ok("success");
    }
}
