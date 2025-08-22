package com.ultra_tutor.ultra_tutor_api.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CaptureDTO {
    private UUID id;
    private String sourceUrl;
    private String pageTitle;
    private String faviconUrl;
    private String selectedText;
    private String surroundingParagraph;
}
