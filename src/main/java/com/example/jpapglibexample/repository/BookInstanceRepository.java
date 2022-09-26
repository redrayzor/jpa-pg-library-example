package com.example.jpapglibexample.repository;

import com.example.jpapglibexample.model.BookInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookInstanceRepository extends JpaRepository<BookInstance,Long> {
}
