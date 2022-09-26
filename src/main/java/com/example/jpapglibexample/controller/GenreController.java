package com.example.jpapglibexample.controller;

import com.example.jpapglibexample.model.Genre;
import com.example.jpapglibexample.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    GenreRepository genreRepository;

    @GetMapping("/")
    public ResponseEntity<List<Genre>> getAllGenres() {
        try {
            List<Genre> genres = new ArrayList<Genre>();
            genreRepository.findAll().forEach(genres::add);
            if (genres.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(genres, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable("id") long id) {
        Optional<Genre> genreData = genreRepository.findById(id);
        if (genreData.isPresent()) {
            return new ResponseEntity<>(genreData.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        try {
            Genre _genre = genreRepository
                    .save(new Genre(genre.getName()));
            return new ResponseEntity<>(_genre,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable("id") long id, @RequestBody Genre genre) {
        Optional<Genre> genreData = genreRepository.findById(id);
        if (genreData.isPresent()) {
            Genre _genre = genreData.get();
            _genre.setName(genre.getName());
            return new ResponseEntity<>(genreRepository.save(_genre),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteGenre(@PathVariable("id") long id) {
        try {
            genreRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
