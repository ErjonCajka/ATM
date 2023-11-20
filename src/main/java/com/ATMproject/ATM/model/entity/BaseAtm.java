package com.ATMproject.ATM.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;

@Getter@Setter
@MappedSuperclass

public class BaseAtm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime createdDate;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    public LocalDateTime lastModifiedDate;

    private boolean deleted;


}
