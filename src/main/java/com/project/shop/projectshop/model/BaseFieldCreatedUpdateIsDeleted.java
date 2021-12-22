package com.project.shop.projectshop.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseFieldCreatedUpdateIsDeleted {
    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @Column(name = "created_by", updatable = false)
    private Long createdBy;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
}
