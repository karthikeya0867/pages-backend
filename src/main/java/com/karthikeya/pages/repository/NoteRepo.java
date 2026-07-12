package com.karthikeya.pages.repository;

import com.karthikeya.pages.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteRepo extends JpaRepository<Note , UUID> {
}
