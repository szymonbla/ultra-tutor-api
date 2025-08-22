package com.ultra_tutor.ultra_tutor_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(updatable = false, nullable = false)
    private UUID id;

//    @Column(updatable = false)
//    @CreatedBy
//    private String createdBy;

    @CreatedDate
    @Column(updatable = false)
    private Instant createdDate;

//    @LastModifiedBy
//    private String lastModifiedBy;

    @LastModifiedDate
    private Instant lastModifiedDate;
}
