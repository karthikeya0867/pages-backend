package com.karthikeya.pages.repository;

import com.karthikeya.pages.entity.NoteBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteBlockRepo extends JpaRepository<NoteBlock , UUID> {
}
