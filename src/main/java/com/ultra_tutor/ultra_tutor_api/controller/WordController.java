package com.ultra_tutor.ultra_tutor_api.controller;

import com.ultra_tutor.ultra_tutor_api.model.Word;
import com.ultra_tutor.ultra_tutor_api.model.command.CreateWordCommand;
import com.ultra_tutor.ultra_tutor_api.model.dto.WordDTO;
import com.ultra_tutor.ultra_tutor_api.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/words")
public class WordController {
    private final WordService wordService;

    @PostMapping
    public ResponseEntity<WordDTO> createWord(@RequestBody CreateWordCommand createWordCommand) {
        return new ResponseEntity<>(wordService.createWord(createWordCommand), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WordDTO>> findAll() {
        return new ResponseEntity<>(wordService.findAllWords(), HttpStatus.OK);
    }
}
