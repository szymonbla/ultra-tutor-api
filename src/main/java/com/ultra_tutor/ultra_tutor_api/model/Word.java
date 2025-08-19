package com.ultra_tutor.ultra_tutor_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.URL;

import java.util.UUID;

@Entity
@Table(name = "Words")
@Getter
@Setter
public class Word {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID wordId;

    @Size(min = 1)
    private String selectedText;
    @URL
    private String url;
    private String context;
}
