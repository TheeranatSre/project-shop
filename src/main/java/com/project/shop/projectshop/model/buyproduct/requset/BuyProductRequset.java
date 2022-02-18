package com.project.shop.projectshop.model.buyproduct.requset;

import lombok.Data;

@Data
public class BuyProductRequset {
    private Long id;

    private Long userBy;

    private Long userSell;

    private Long productId;

    private String key;

    private Long unitAmount;

    private Long price;
}
