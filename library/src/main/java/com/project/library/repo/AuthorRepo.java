package com.project.library.repo;

import com.project.library.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author,Long> {
}
