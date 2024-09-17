package com.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@EntityListeners(AuditingEntityListener.class)
@Getter
@ToString
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    LocalDate createdAt;

    @CreatedBy
    @Column(updatable = false)
    String createdBy;

    @LastModifiedDate
    @Column(insertable = false)
    LocalDate updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    String updatedBy;
}
