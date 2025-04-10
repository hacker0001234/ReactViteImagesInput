package com.example.aplicationTest.repositories;

import com.example.aplicationTest.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
Users findByEmail(String email);
}
