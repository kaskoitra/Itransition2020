package com.example.dao;

import com.example.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesDao extends JpaRepository<Notes, Long> {

    @SuppressWarnings("unchecked2")
    Notes save(Notes notes);
}
