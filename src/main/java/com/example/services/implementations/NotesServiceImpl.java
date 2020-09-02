package com.example.services.implementations;

import com.example.dao.NotesDao;
import com.example.entity.Notes;
import com.example.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("notesService")
public class NotesServiceImpl implements NotesService {

    @Autowired
    protected NotesDao notesDao;

    @Override
    public Notes save(Notes notes){
        return this.notesDao.save(notes);
    }

    @Override
    public List<Notes> findAll() {
        return this.notesDao.findAll();
    }

    @Override
    public void deleteNotes(Long id) {
        this.notesDao.deleteById(id);
    }

}
