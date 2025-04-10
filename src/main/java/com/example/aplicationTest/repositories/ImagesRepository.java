package com.example.aplicationTest.repositories;

import com.example.aplicationTest.entities.Images;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImagesRepository extends JpaRepository<Images,Long> {
    Optional<Images> findById(Long id);

    Images findByEmail(String email);
}
