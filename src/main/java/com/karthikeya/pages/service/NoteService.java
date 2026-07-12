package com.karthikeya.pages.service;

import com.karthikeya.pages.dto.request.NoteReq;
import com.karthikeya.pages.entity.Note;
import com.karthikeya.pages.entity.User;
import com.karthikeya.pages.repository.NoteRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepo noteRepo;

    public void createNote(NoteReq noteReq) {

        User user = User.builder()
                .email("kdksk@kfdd.com")
                .username("friend")
                .password("qwe1234@")
                .build();


        Note note = Note.builder()
                .title(noteReq.title())
                .owner(user)
                .build();

        noteRepo.save(note);

    }

    public void fetchNote(){

    }
}
