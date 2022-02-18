package com.project.shop.projectshop.repository.userbuy;

import com.project.shop.projectshop.model.buyproduct.BuyProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyProductRepository extends JpaRepository<BuyProductEntity, Long> {
  
}
