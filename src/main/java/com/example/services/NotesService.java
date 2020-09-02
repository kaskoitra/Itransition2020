package com.example.services;

import com.example.entity.Notes;

import java.util.List;

public interface NotesService {

    /**
     * Save notes in the DB
     * @param notes added note
     * @return saved notes
     */
    Notes save(Notes notes);

    /**
     * Find all notes in the DB
     * @return List<Notes> list of all notes
     */
    List<Notes> findAll();

    /**
     * Delete notes with this id
     * @param id for deleting notices
     */
    void deleteNotes(Long id);
}
