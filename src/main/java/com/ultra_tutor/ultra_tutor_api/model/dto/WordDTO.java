package com.ultra_tutor.ultra_tutor_api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class WordDTO {
    private UUID wordId;
    private String selectedText;
    private String url;
    private String context;
}
