package com.example.jpapglibexample.repository;

import com.example.jpapglibexample.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
