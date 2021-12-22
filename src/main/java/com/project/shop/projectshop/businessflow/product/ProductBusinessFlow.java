package com.project.shop.projectshop.businessflow.product;

import com.project.shop.projectshop.busibess.product.ProductBusiness;
import com.project.shop.projectshop.model.product.ProductEntity;
import com.project.shop.projectshop.model.product.requset.CreateProductRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductBusinessFlow {
  private @Autowired ProductBusiness productBusiness;
    public ProductEntity saveAndValidateProduct(Long userId, CreateProductRequest request) {
        return productBusiness.saveProduct(request, userId);
    }
}
