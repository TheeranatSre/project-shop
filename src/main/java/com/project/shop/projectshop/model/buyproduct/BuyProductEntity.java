package com.project.shop.projectshop.model.buyproduct;

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
@Table(name = "log_buy_product", schema = "shop")
public class BuyProductEntity extends BaseFieldCreatedUpdateIsDeleted {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_buy")
    private Long userBy;

    @Column(name = "user_sell")
    private Long userSell;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "key")
    private String key;

    @Column(name = "unit_amount")
    private Long unitAmount;

    @Column(name = "price")
    private Long price;
}
