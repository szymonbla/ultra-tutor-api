package com.ultra_tutor.ultra_tutor_api.service;

import com.ultra_tutor.ultra_tutor_api.model.Word;
import com.ultra_tutor.ultra_tutor_api.model.command.CreateWordCommand;
import com.ultra_tutor.ultra_tutor_api.model.dto.WordDTO;
import com.ultra_tutor.ultra_tutor_api.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordRepository wordRepository;
    private final ModelMapper modelMapper;

    public WordDTO createWord(CreateWordCommand createWordCommand) {
        Word word = new Word();
        word.setContext(createWordCommand.getContext());
        word.setUrl(createWordCommand.getUrl());
        word.setSelectedText(createWordCommand.getSelectedText());
        return modelMapper.map(wordRepository.save(word), WordDTO.class);
    }

    public List<WordDTO> findAllWords() {
        return wordRepository.findAll()
                .stream()
                .map((word -> modelMapper.map(word, WordDTO.class)))
                .toList();
    }
}
