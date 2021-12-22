package com.project.shop.projectshop.model.product.requset;

import lombok.Data;

@Data
public class CreateProductRequest {
    private Long id;
    private String name;
    private String key;
    private String detail;
    private Long unitAmount;
    private Long price;
    private Boolean isDeleted = false;
}
