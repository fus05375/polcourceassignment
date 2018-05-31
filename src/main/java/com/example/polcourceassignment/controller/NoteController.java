package com.example.polcourceassignment.controller;

import com.example.polcourceassignment.model.Note;
import com.example.polcourceassignment.model.Tag;
import com.example.polcourceassignment.repository.NoteRespoitory;
import com.example.polcourceassignment.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/notes")
public class NoteController {

    private NoteRespoitory noteRespoitory;
    private TagRepository tagRepository;


    @Autowired
    public NoteController(NoteRespoitory noteRespoitory,TagRepository tagRepository) {
        this.noteRespoitory = noteRespoitory;
        this.tagRepository = tagRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Note> getAll() {
        return noteRespoitory.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public  List<Note> create(@RequestBody Note simpleNote){
        noteRespoitory.save(simpleNote);

        return noteRespoitory.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Note> delete(@PathVariable Long id){
        noteRespoitory.deleteById(id);
        return noteRespoitory.findAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public List<Note> update(@PathVariable Long id,
                                   @Valid @RequestBody Note noteDetails){
        Note updateNote = noteRespoitory.findById(id).get();
        updateNote.setTitle(noteDetails.getTitle());
        updateNote.setContent(noteDetails.getContent());
        noteRespoitory.save(updateNote);
        return noteRespoitory.findAll();
    }
    @RequestMapping(value = "/update/{id}/addTag/{tagId}", method = RequestMethod.PUT)
    public  List<Note> addTag(@PathVariable Long id,@PathVariable Long tagId){
        Note updateNote = noteRespoitory.findById(id).get();
        Tag setTag = tagRepository.findById(tagId).get();
        updateNote.setTag( setTag);
        noteRespoitory.save(updateNote);

        return noteRespoitory.findAll();
    }

    @RequestMapping(value = "/update/{id}/delTag/{tagId}", method = RequestMethod.GET)
    public  List<Note> deleteTag(@PathVariable Long id,@PathVariable Long tagId){
        Note updateNote = noteRespoitory.findById(id).get();
        Tag setTag = tagRepository.findById(tagId).get();
        updateNote.delTag(setTag);
        noteRespoitory.save(updateNote);

        return noteRespoitory.findAll();
    }

}
