package com.example.jpapglibexample.repository;

import com.example.jpapglibexample.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
