package com.example.jpapglibexample.controller;

import com.example.jpapglibexample.model.BookInstance;
import com.example.jpapglibexample.repository.BookInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/bookInstance")
public class BookInstanceController {
    @Autowired
    BookInstanceRepository bookInstanceRepository;

    @GetMapping("/")
    public ResponseEntity<List<BookInstance>> getAllBookInstances() {
        try {
            List<BookInstance> bookInstances = new ArrayList<BookInstance>();
            bookInstanceRepository.findAll().forEach(bookInstances::add);
            if (bookInstances.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(bookInstances, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookInstance> getBookInstanceById(@PathVariable("id") long id) {
        Optional<BookInstance> bookInstanceData = bookInstanceRepository.findById(id);
        if (bookInstanceData.isPresent()) {
            return new ResponseEntity<>(bookInstanceData.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<BookInstance> createBookInstance(@RequestBody BookInstance bookInstance) {
        try {
            BookInstance _bookInstance = bookInstanceRepository
                    .save(new BookInstance(bookInstance.getBook(), bookInstance.getImprint(), bookInstance.getStatus(), bookInstance.getDue_back()));
            return new ResponseEntity<>(_bookInstance,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookInstance> updateBookInstance(@PathVariable("id") long id, @RequestBody BookInstance bookInstance) {
        Optional<BookInstance> bookInstanceData = bookInstanceRepository.findById(id);
        if (bookInstanceData.isPresent()) {
            BookInstance _bookInstance = bookInstanceData.get();
            _bookInstance.setBook(bookInstance.getBook());
            _bookInstance.setImprint(bookInstance.getImprint());
            _bookInstance.setStatus(bookInstance.getStatus());
            _bookInstance.setDue_back(bookInstance.getDue_back());
            return new ResponseEntity<>(bookInstanceRepository.save(_bookInstance),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteBookInstance(@PathVariable("id") long id) {
        try {
            bookInstanceRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
