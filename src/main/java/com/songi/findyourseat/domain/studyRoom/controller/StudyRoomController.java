package com.songi.findyourseat.domain.studyRoom.controller;

import com.songi.findyourseat.domain.studyRoom.controller.dto.StudyRoomSeatsInfo;
import com.songi.findyourseat.domain.studyRoom.service.StudyRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/studyRoom")
@RequiredArgsConstructor
public class StudyRoomController {

    private final StudyRoomService studyRoomService;

    @GetMapping("/seats")
    public ResponseEntity<StudyRoomSeatsInfo> getSeatsInfo() {

        return ResponseEntity.ok(StudyRoomSeatsInfo.from());
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
            @PathVariable Long seatId,
            @RequestBody String userId
    ) {
//        studyRoomService.checkout();
        return ResponseEntity.ok("success");
    }
}
