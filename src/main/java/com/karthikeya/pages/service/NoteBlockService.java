package com.karthikeya.pages.service;

import com.karthikeya.pages.dto.request.NoteBlockReq;
import com.karthikeya.pages.entity.Note;
import com.karthikeya.pages.entity.NoteBlock;
import com.karthikeya.pages.repository.NoteBlockRepo;
import com.karthikeya.pages.repository.NoteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteBlockService {

    private final NoteBlockRepo noteBlockRepo;
    private final NoteRepo noteRepo;

    public void createNoteBlock(UUID noteId, NoteBlockReq req) {

        Note note = noteRepo.findById(noteId)
                .orElseThrow(() -> new RuntimeException("Note not found"));

        NoteBlock noteBlock = NoteBlock.builder()
                .note(note)
                .blockType(req.getBlockType())
                .position(req.getPosition())
                .payload(req.getPayload())
                .build();

        noteBlockRepo.save(noteBlock);
    }
}