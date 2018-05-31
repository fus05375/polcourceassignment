package com.example.polcourceassignment.controller;

import com.example.polcourceassignment.model.Tag;
import com.example.polcourceassignment.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tags")
public class TagController {
    TagRepository tagRepository;


    @Autowired
    public TagController(TagRepository tagRepository){
        this.tagRepository=tagRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Tag> getAll(){
        return tagRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Tag> create(@RequestBody Tag tag){
        tagRepository.save(tag);

        return tagRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<Tag> remove(@PathVariable Long id){
        tagRepository.deleteById(id);
        return tagRepository.findAll();
    }
}
