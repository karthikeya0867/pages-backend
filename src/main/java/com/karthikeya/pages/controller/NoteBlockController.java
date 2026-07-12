package com.karthikeya.pages.controller;

import com.karthikeya.pages.dto.request.NoteBlockReq;
import com.karthikeya.pages.dto.response.ApiResponse;
import com.karthikeya.pages.service.NoteBlockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteBlockController {

    private final NoteBlockService noteBlockService;

    @PostMapping("/{id}/blocks")
    public ResponseEntity<ApiResponse<?>> createNoteBlock(@PathVariable UUID id ,
                                                          @RequestBody NoteBlockReq noteBlockReq
                                                          ) {

        noteBlockService.createNoteBlock(id, noteBlockReq);
        return ResponseEntity.ok(ApiResponse.success("Note Block Created"));
    }
}
