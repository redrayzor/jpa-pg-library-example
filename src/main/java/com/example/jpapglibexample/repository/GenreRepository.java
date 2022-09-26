package com.example.jpapglibexample.repository;

import com.example.jpapglibexample.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
}
