package com.karthikeya.pages.controller;

import com.karthikeya.pages.dto.request.NoteReq;
import com.karthikeya.pages.dto.response.ApiResponse;
import com.karthikeya.pages.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<?>> createNote(@RequestBody NoteReq noteReq) {
        noteService.createNote(noteReq);
        return ResponseEntity.ok(ApiResponse.success("Note Created"));
    }

}
