package com.project.shop.projectshop.repository.product;

import java.util.List;

import com.project.shop.projectshop.model.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Long>,
        JpaSpecificationExecutor<ProductEntity>, JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findAllByCreatedBy(Long createdBy);
}
