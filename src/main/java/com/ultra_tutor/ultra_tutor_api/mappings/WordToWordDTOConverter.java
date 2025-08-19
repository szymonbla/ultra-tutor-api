package com.ultra_tutor.ultra_tutor_api.mappings;


import com.ultra_tutor.ultra_tutor_api.model.Word;
import com.ultra_tutor.ultra_tutor_api.model.dto.WordDTO;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component
public class WordToWordDTOConverter implements Converter<Word, WordDTO> {
    @Override
    public WordDTO convert(MappingContext<Word, WordDTO> mappingContext) {
        WordDTO wordDTO = new WordDTO();
        wordDTO.setWordId(mappingContext.getSource().getWordId());
        wordDTO.setUrl(mappingContext.getSource().getUrl());
        wordDTO.setSelectedText(mappingContext.getSource().getSelectedText());
        wordDTO.setContext(mappingContext.getSource().getContext());
        return wordDTO;
    }
}
