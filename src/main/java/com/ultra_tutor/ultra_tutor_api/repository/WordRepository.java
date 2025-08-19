package com.ultra_tutor.ultra_tutor_api.repository;

import com.ultra_tutor.ultra_tutor_api.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WordRepository extends JpaRepository<Word, UUID> {
}
