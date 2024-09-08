package com.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@ToString
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity {

    @Column(updatable = false)
    LocalDate createdAt;
    @Column(updatable = false)
    String createdBy;
    @Column(insertable = false)
    LocalDate updatedAt;
    @Column(insertable = false)
    String updatedBy;
}
