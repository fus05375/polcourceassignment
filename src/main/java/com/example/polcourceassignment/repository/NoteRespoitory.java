package com.example.polcourceassignment.repository;


import com.example.polcourceassignment.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRespoitory extends JpaRepository<Note, Long> {


}
