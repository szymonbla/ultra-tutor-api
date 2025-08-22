package com.ultra_tutor.ultra_tutor_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SoftDelete;

@Getter
@Setter
@Table(name = "captures")
@Entity
@SoftDelete
public class Capture extends BaseEntity {
    private String sourceUrl;
    private String pageTitle;
    private String faviconUrl;
    private String selectedText;
    private String surroundingParagraph;
}
