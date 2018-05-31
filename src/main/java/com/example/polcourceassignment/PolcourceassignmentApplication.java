package com.example.polcourceassignment;

import com.example.polcourceassignment.model.Note;
import com.example.polcourceassignment.model.Tag;
import com.example.polcourceassignment.repository.NoteRespoitory;
import com.example.polcourceassignment.repository.TagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.HashSet;
import java.util.Set;


@EnableJpaAuditing /* needed to create/update entity */
@SpringBootApplication
public class PolcourceassignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(PolcourceassignmentApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(NoteRespoitory noteRepository, TagRepository tagRepository) {
        return (args) -> {
            // save notes
            Note note1 = new Note("Sesja", "Sesja tuż tuż");
            Note note12 = new Note("Sesja2", "2Sesja tuż tuż2");

            noteRepository.save(new Note("Ala", "Ma Kota"));
            noteRepository.save(new Note("Kot", "Ma Ale"));
            noteRepository.save(new Note("Urodziny", "jutro"));
            noteRepository.save(new Note("Pogrzeb", "dzis"));

            Tag tag = new Tag("Urgent");
            Tag tag1 = new Tag("Important");
            tagRepository.save(new Tag("Trash"));

            tagRepository.save(tag);
            tagRepository.save(tag1);


            Set<Tag> tags = new HashSet<Tag>();
            tags.add(tag);
            tags.add(tag1);


            note1.setTags(tags);
            note12.setTags(tags);
            noteRepository.save(note1);
            noteRepository.save(note12);

        };
    }
}
