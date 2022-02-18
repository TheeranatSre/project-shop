package com.project.shop.projectshop.controller;

import com.project.shop.projectshop.businessflow.buyproduct.BuyProductBusinessFlow;
import com.project.shop.projectshop.model.buyproduct.BuyProductEntity;
import com.project.shop.projectshop.model.buyproduct.requset.BuyProductRequset;
import com.project.shop.projectshop.model.exception.ValidateException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyProductController {

    private @Autowired BuyProductBusinessFlow buyProductBusinessFlow;

    @PostMapping("/buy-products/{id}")
    public BuyProductEntity postProduct(@PathVariable Long id, @RequestHeader Long userId, @RequestBody BuyProductRequset request) throws ValidateException {
        return buyProductBusinessFlow.createdLogBuyProduct(id, userId, request);
    }

}
