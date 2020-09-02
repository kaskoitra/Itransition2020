package com.example.controllers.userControllers;

import com.example.entity.Notes;
import com.example.dto.RestResponseDto;
import com.example.services.NotesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import javax.persistence.Lob;

import static java.util.Objects.isNull;

/**
 *Controller for to save, change and delete notes
 */

@RestController
public class NotesController {

    @Resource
    protected NotesService notesService;

    private ObjectMapper mapper;

    @Lob
    @RequestMapping(value="/saveNotes", method = RequestMethod.POST)
    public RestResponseDto saveNotes(@RequestBody final String notesJson) throws IOException,
        JsonParseException {
        this.mapper = new ObjectMapper();
        Notes notes = this.mapper.readValue(notesJson, Notes.class);
        if(!this.validate(notes)){
            return new RestResponseDto(HttpStatus.NOT_ACCEPTABLE.value(), "Please, add a new note! ");
        }
        this.notesService.save(notes);
        return new RestResponseDto(HttpStatus.OK.value(), "Operation is great!");
    }

    @RequestMapping(value = "/getNotes", method = RequestMethod.GET)
    public List<Notes> getNotes(){
        return this.notesService.findAll();
    }

    @RequestMapping(value = "/deleteNotes", method = RequestMethod.POST)
    public void deleteNotes(@RequestBody final String notesJson) throws Exception {
        this.mapper = new ObjectMapper();
        Notes notes = this.mapper.readValue(notesJson, Notes.class);
        if (isNull(notes.getId())) {
            throw new Exception("Id is not found!");
        }
        this.notesService.deleteNotes(notes.getId());
    }

    private boolean validate (Notes notes) {
        boolean isValid = true;
        if (isNull(StringUtils.trimToNull(notes.getTag()))) {
            isValid = false;
        }
        if (isNull(StringUtils.trimToNull(notes.getContent()))) {
            isValid = false;
        }
        return isValid;
    }
}

