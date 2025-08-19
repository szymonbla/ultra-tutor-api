package com.ultra_tutor.ultra_tutor_api.model.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateWordCommand {
    private String selectedText;
    private String url;
    private String context;
}
