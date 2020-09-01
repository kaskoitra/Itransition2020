package com.example.services;

import com.example.entity.Notes;

import java.util.List;

public interface NotesService {

    Notes save(Notes notes);

    List<Notes> findAll();

    void deleteNotes(Long id);
}
