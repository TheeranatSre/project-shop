package com.project.shop.projectshop.controller;

import java.util.List;

import com.project.shop.projectshop.busibess.page.PageBusiness;
import com.project.shop.projectshop.busibess.product.ProductBusiness;
import com.project.shop.projectshop.businessflow.product.ProductBusinessFlow;
import com.project.shop.projectshop.model.common.PageResponse;
import com.project.shop.projectshop.model.exception.ValidateException;
import com.project.shop.projectshop.model.product.ProductEntity;
import com.project.shop.projectshop.model.product.dto.FilterProductDto;
import com.project.shop.projectshop.model.product.requset.CreateProductRequest;
import com.project.shop.projectshop.repository.product.ProductRepository;
import com.project.shop.projectshop.spec.product.ProductSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private @Autowired ProductRepository productRepository;
    private @Autowired ProductSpec productSpec;
    private @Autowired PageBusiness pageBusiness;
    private @Autowired ProductBusiness productBusiness;
    private @Autowired ProductBusinessFlow productBusinessFlow;

    @GetMapping("/products")
    public PageResponse<ProductEntity> getProducts(FilterProductDto filterProductDto, @RequestParam(required = true, defaultValue="1") String page, 
    @RequestParam(required = true, defaultValue="20") String pageSize)
            throws ValidateException {
                Pageable pageable = PageRequest.of(Integer.parseInt(page)-1, Integer.parseInt(pageSize));
        Specification<ProductEntity> specEntity = productSpec.getSiteSpecificationByFilterDto(filterProductDto);
        List<ProductEntity> productEntity = productRepository.findAll(specEntity, Sort.by("updatedAt").descending());
        Page<ProductEntity> products = pageBusiness.getPageResponse(productEntity, pageable);
        Long totalElement = Long.valueOf(productEntity.size());
        return PageResponse.create(products, products.getContent(), totalElement);
    }

    @GetMapping("/my-products")
    public PageResponse<ProductEntity> getMyProduct(@RequestHeader Long userId, @RequestParam(required = true, defaultValue="1") String page, 
    @RequestParam(required = true, defaultValue="20") String pageSize) {
        Pageable pageable = PageRequest.of(Integer.parseInt(page)-1, Integer.parseInt(pageSize));
        List<ProductEntity> productEntity = productRepository.findAllByCreatedBy(userId);
        Page<ProductEntity> products = pageBusiness.getPageResponse(productEntity, pageable);
        Long totalElement = Long.valueOf(productEntity.size());
        return PageResponse.create(products, products.getContent(), totalElement);
    }

    @GetMapping("/carts/{id}")
    public ProductEntity getProductById(@PathVariable Long id) throws ValidateException {
        return productBusiness.getProductByIdOrElseThrowIfNotExist(id);
    }

    @PostMapping("/products")
    public ProductEntity postProduct(@RequestHeader Long userId, @RequestBody CreateProductRequest request) {
        return productBusinessFlow.saveAndValidateProduct(userId, request);
    }

    @PatchMapping("/products/{id}")
    public ProductEntity patchProduct(@RequestHeader Long userId, @RequestBody CreateProductRequest request, @PathVariable Long id) {
        request.setId(id);
        return productBusinessFlow.saveAndValidateProduct(userId, request);
    }

    @GetMapping("/test")
    public String test() {
        return "test api";
    }
}
