package com.project.shop.projectshop.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.shop.projectshop.model.BaseFieldCreatedUpdateIsDeleted;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "product", schema = "shop")
public class ProductEntity extends BaseFieldCreatedUpdateIsDeleted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "key")
    private String key;

    @Column(name = "detail")
    private String detail;

    @Column(name = "unit_amount")
    private Long unitAmount;

    @Column(name = "price")
    private Long price;
}
